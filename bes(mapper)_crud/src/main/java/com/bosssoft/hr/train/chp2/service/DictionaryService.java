package com.bosssoft.hr.train.chp2.service;

import com.bosssoft.hr.train.chp2.pojo.entity.Dictionary;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author ztanker
 * @date 2019-07-25 15:34
 * @Description
 */
public interface DictionaryService {
    /**
     * 按主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     * @param dictionary
     * @return
     */
    int insert(Dictionary dictionary);

    /**
     * 按主键获取单个
     * @param id
     * @return
     */
    Dictionary queryOne(Long id);

    /**
     * 获取全部
     * @return
     */
    List<Dictionary> queryAll();

    /**
     * 更新
     * @param dictionary
     * @return
     */
    int updateByPrimaryKey(Dictionary dictionary);

    /**
     * 条件查询
     * @param condition
     * @return
     */
    List<Dictionary> selectByExample(Condition condition);
}
