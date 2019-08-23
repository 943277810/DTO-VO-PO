package com.bosssoft.hr.train.chp2.controller;


import com.bosssoft.hr.train.chp2.dao.UserDao;
import com.bosssoft.hr.train.chp2.pojo.dto.UserDto;
import com.bosssoft.hr.train.chp2.pojo.entity.User;
import com.bosssoft.hr.train.chp2.pojo.vo.UserVo;
import com.bosssoft.hr.train.chp2.service.UserService;
import com.bosssoft.hr.train.chp2.util.CommonResponse;
import com.google.gson.Gson;
import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;

/**
 * @author 94327
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUserOne/{id}")
    public CommonResponse queryOneById(@PathVariable Integer id) {
        UserDto userDto = userService.queryOne(id);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setVersion("11");
        Gson gson = new Gson();
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDto, userVo);
        commonResponse.setBody(gson.toJson(userVo));
        return commonResponse;
    }

    @RequestMapping(value ="insertUser")
    public  CommonResponse insertUser(@Value UserDto userDto){
        int result = userService.insert(userDto,new User());
        return null;
    }

    @RequestMapping(value ="updateUser")
    public  CommonResponse updateUser(@Value UserDto userDto){
        int result = userService.update(userDto);
        return null;
    }

    @RequestMapping(value = "deleteUser/{id}")
    public CommonResponse deleteUser(@PathVariable Integer id){
        int result = userService.delete(id);
        return null;
    }


    @RequestMapping("/fun-queryCondition")
    public String funq2() throws Exception {
        UserDto userDto = new UserDto();
        return userService.queryByCondition(userDto,2).toString();
    }
}
