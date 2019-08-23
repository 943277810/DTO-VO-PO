package com.bosssoft.hr.train.chp2.service;

import com.bosssoft.hr.train.chp2.pojo.dto.UserDto;
import com.bosssoft.hr.train.chp2.pojo.entity.User;
import com.bosssoft.hr.train.chp2.pojo.vo.UserVo;

import java.util.List;

/**
 * @author 94327
 */
public interface UserService {
    /**
     * 插入
     * @param userDto
     * @return
     */
    int insert(UserDto userDto , User user);
    /**
     * 更新
     * @param userDto
     * @return
     */
    int update(UserDto userDto);

    /**
     * 按主键获取单个
     * @param id
     * @return
     */
    UserDto queryOne(Integer id);
    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据条件查询记录，当Condition为空时，返回所有
     * @param userDto
     * @param pageNum
     * @return
     * @throws Exception
     */
    List<UserDto> queryByCondition(UserDto userDto,int pageNum) throws Exception;
}
