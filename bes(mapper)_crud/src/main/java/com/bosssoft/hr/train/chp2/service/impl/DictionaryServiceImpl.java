package com.bosssoft.hr.train.chp2.service.impl;

import com.bosssoft.hr.train.chp2.aspect.annotation.Log;
import com.bosssoft.hr.train.chp2.dao.DictionaryDao;
import com.bosssoft.hr.train.chp2.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp2.service.DictionaryService;
import com.bosssoft.hr.train.chp2.util.SnowFlake;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ztanker
 * @date 2019-07-25 15:35
 * @Description
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Gson gson;


    private Random random = new Random();
    @Log("deleteByPrimaryKey")
    @Override
    public int deleteByPrimaryKey(Long id) {
        Boolean delete = stringRedisTemplate.delete("Dictionary_" + id);
//        if (delete.equals(true)){
//            LOGGER.info("Delete from redis:id="+id);
//        } else {
//            LOGGER.info("Nothing to delete from redis.");
//        }
        int row = dictionaryDao.deleteByPrimaryKey(id);
        return row;
    }

    @Log("insert")
    @Override
    public int insert(Dictionary dictionary) {
        SnowFlake snowFlake = new SnowFlake(1,1);
        Long newCategoryId = snowFlake.nextId();
        dictionary.setCategoryId(newCategoryId);
        //暂时把新建的账户其他属性值固定为以下。
        dictionary.setCreatedBy(0L);
        dictionary.setCreatedTime(new Date());
        dictionary.setUpdatedBy(0L);
        dictionary.setUpdatedTime(new Date());
        dictionary.setOrgId(0L);
        dictionary.setVersion(1L);
//        String redisKey = "Dictionary_" + dictionary.getCategoryId();
//        Boolean hasKey =stringRedisTemplate.hasKey(redisKey) ;
//        stringRedisTemplate.opsForValue().set(redisKey,gson.toJson(dictionary),12+random.nextInt(10), TimeUnit.HOURS);
//        LOGGER.info("Writing into redis.(insert)"+dictionary.toString());
        return dictionaryDao.insert(dictionary);
    }

    @Log("queryOne")
    @Override
    public Dictionary queryOne(Long id) {
        String redisKey = "Dictionary_" + id;
        boolean hasKey = stringRedisTemplate.hasKey(redisKey);
        Dictionary dictionary = null;
//        if (hasKey){
//            String aCache = stringRedisTemplate.opsForValue().get(redisKey);
//            dictionary = gson.fromJson(aCache,Dictionary.class);
//            LOGGER.info("Reading from redis.(queryOne)"+dictionary.toString());
//        } else {
//
//            stringRedisTemplate.opsForValue().set(redisKey,gson.toJson(dictionary),12+random.nextInt(10), TimeUnit.HOURS);
//            LOGGER.info("Writing into redis.(queryOne)"+dictionary.toString());
//        }
        dictionary = dictionaryDao.selectByPrimaryKey(id);
        return dictionary;
    }

    @Log("queryAll")
    @Override
    public List<Dictionary> queryAll() {
        List<Dictionary> dictionaryList = dictionaryDao.selectAll();
        if (dictionaryList!=null && !dictionaryList.isEmpty()){
            for (Dictionary dictionary:dictionaryList){
                stringRedisTemplate.opsForValue().set("Dictionary_"+dictionary.getCategoryId(),gson.toJson(dictionary),12+random.nextInt(10),TimeUnit.HOURS);
                LOGGER.info("Writing into redis.(queryAll)"+dictionary.toString());
            }
        }
        return dictionaryList;
    }

    @Log("updateByPrimaryKey")
    @Override
    public int updateByPrimaryKey(Dictionary dictionary) {
        if (dictionary != null){
            //empty?
            //------------------------Version=time，前台传送
            //========BusinessException

            //前后端分离以后应该由前端传送 后端验证
            dictionary.setVersion(System.currentTimeMillis());
            String redisKey = "Dictionary_" + dictionary.getCategoryId();
            boolean hasKey = stringRedisTemplate.hasKey(redisKey);
            stringRedisTemplate.opsForValue().set(redisKey,gson.toJson(dictionary),12+random.nextInt(10), TimeUnit.HOURS);
            LOGGER.info("Writing into redis.(update)"+dictionary.toString());
        }
        return dictionaryDao.updateByPrimaryKey(dictionary);
    }

    @Override
    public List<Dictionary> selectByExample(Condition condition) {
        List<Dictionary> dictionaryList = dictionaryDao.selectByExample(condition);
        return dictionaryList;
    }

}
