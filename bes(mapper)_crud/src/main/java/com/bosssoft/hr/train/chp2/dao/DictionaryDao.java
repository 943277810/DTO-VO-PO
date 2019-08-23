package com.bosssoft.hr.train.chp2.dao;

import com.bosssoft.hr.train.chp2.basedao.BaseDao;
import com.bosssoft.hr.train.chp2.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 章邴瀚
 * @date 2019-07-24 16:46
 * @Description
 */

@Mapper
@Repository
public interface DictionaryDao extends BaseDao<Dictionary> {

}
