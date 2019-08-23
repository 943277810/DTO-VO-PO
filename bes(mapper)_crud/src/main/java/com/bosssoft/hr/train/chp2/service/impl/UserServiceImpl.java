package com.bosssoft.hr.train.chp2.service.impl;

import com.bosssoft.hr.train.chp2.dao.UserDao;
import com.bosssoft.hr.train.chp2.pojo.dto.UserDto;
import com.bosssoft.hr.train.chp2.pojo.entity.User;
import com.bosssoft.hr.train.chp2.pojo.vo.UserVo;
import com.bosssoft.hr.train.chp2.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 94327
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao ;

    @Override
    public int insert(UserDto userDto,User user) {
/*        User user = new User();*/
        BeanUtils.copyProperties(userDto, user);
        return userDao.insert(user);
    }

    @Override
    public UserDto queryOne(Integer id) {
        UserDto userDto = new UserDto();
        User user = userDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public  int update(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
       return  userDao.updateByPrimaryKey(user);
    }

    @Override
    public int delete(Integer id){
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
   public List<UserDto> queryByCondition(UserDto userDto,@RequestParam(defaultValue = "1",value = "pageNum") int pageNum) throws Exception{
        PageHelper.startPage(pageNum,2);
        Condition condition = new Condition(User.class);
        Example.Criteria criteria = condition.createCriteria();
        if (!StringUtils.isEmpty(userDto.getName())){
            criteria.andLike("name","%"+userDto.getName()+"%");
        }
        List<User> results = userDao.selectByExample(condition);
        List<UserDto> dtos = null;
        UserDto dto ;
        if (results != null) {
            dtos = new ArrayList<UserDto>(results.size());
            for (User result : results){
                //此处new的做法有待商讨……
                dto = new UserDto();
                BeanUtils.copyProperties(result, dto);
                dtos.add(dto);
            }
        } else {
            dtos = new ArrayList<UserDto>();
        }
        return dtos;
    }
}
