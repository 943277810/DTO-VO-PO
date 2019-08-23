package com.bosssoft.hr.train.chp2.basedao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 章邴瀚
 * @date 2019-07-24 21:38
 * @Description
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
