package com.bosssoft.hr.train.chp2.dao;

import com.bosssoft.hr.train.chp2.basedao.BaseDao;

import com.bosssoft.hr.train.chp2.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 94327
 */
@Mapper
@Repository
public interface UserDao extends BaseDao<User> {

}
