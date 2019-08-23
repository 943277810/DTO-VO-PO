package com.bosssoft.hr.train.chp2.controller;

import com.bosssoft.hr.train.chp2.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp2.service.DictionaryService;
import com.bosssoft.hr.train.chp2.util.SnowFlake;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author ztanker
 * @date 2019-07-25 15:36
 * @Description
 */
@RestController
public class DictionaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

    @Value("${server.port}")
    String port;

    @Autowired
    private DictionaryService dictionaryService;



    /**
     * 模糊查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/searchByCondition")
    public ModelAndView searchByCondition(HttpServletRequest request){
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        System.out.println(name+category);
        ModelAndView mav = new ModelAndView("dictionaryList");
        Condition condition = new Condition(Dictionary.class);
        Example.Criteria criteria = condition.createCriteria();
        StringBuilder conditionString = new StringBuilder();
        //待改进（模糊查询的条件处理应该放在……？）
        int conditionCount = 0;
        if(!StringUtils.isBlank(name)){
            conditionString.append("name like '%" + name + "%'");
            conditionCount ++;
        }
        if (!StringUtils.isBlank(category)){
            if (conditionCount > 0){
                conditionString.append(" or ");
            }
            conditionString.append("category like '%" + category + "%'");
        }
        if (conditionString.length()!=0){
            criteria.andCondition(conditionString.toString());
        }
        List<Dictionary> dictionaryList = dictionaryService.selectByExample(condition);
        mav.addObject("dictionaryList",dictionaryList);
        return mav;
    }

    /**
     * 浏览视图
     * @return
     */
    @RequestMapping(value = "/dictionaryList")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("dictionaryList");
        List<Dictionary> dictionaryList = dictionaryService.queryAll();
        mav.addObject("dictionaryList",dictionaryList);
        mav.addObject("port",port);
        return mav;
    }

    /**
     * 新建视图
     * @return
     */
    @RequestMapping(value = "/newDictionary")
    public ModelAndView newDictionary(){
        ModelAndView mav = new ModelAndView("newDictionary");
        Dictionary dictionary = new Dictionary();
        mav.addObject("dictionary",dictionary);
        return mav;
    }


    /**
     * 新建操作
     * @param dictionary
     * @return
     */
    @RequestMapping(value = "/save")
    public int save(HttpServletResponse httpServletResponse, @Valid Dictionary dictionary){

        int result = dictionaryService.insert(dictionary);
        LOGGER.info("新增操作返回："+result);
        try {
            httpServletResponse.sendRedirect("/dictionaryList");
        } catch (IOException e) {
            LOGGER.error("重定向时出现错误");
        }
        return result;
    }


    /**
     * 编辑视图
     * @param id
     * @return
     */
    @RequestMapping(value = "/editDictionary")
    public ModelAndView editDictionary(Long id){
        ModelAndView mav = new ModelAndView("editDictionary");
        Dictionary dictionary = dictionaryService.queryOne(id);
        mav.addObject("dictionary",dictionary);
        return mav;
    }

    /**
     * 编辑操作
     * @param dictionary
     * @return
     */
    @RequestMapping(value = "/update")
    public int update(HttpServletResponse httpServletResponse, @Valid Dictionary dictionary) {
        dictionary.setUpdatedTime(new Date());
        dictionary.setUpdatedBy(0L);
        int result = dictionaryService.updateByPrimaryKey(dictionary);
        LOGGER.info("更新操作返回："+result);
        try {
            httpServletResponse.sendRedirect("/dictionaryList");
        } catch (IOException e) {
            LOGGER.error("重定向时出现错误");
        }
        return result;
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteDictionary")
    public int deleteDictionary(HttpServletResponse httpServletResponse, Long id) {
        int result = dictionaryService.deleteByPrimaryKey(id);
        try {
            httpServletResponse.sendRedirect("/dictionaryList");
        } catch (IOException e) {
            LOGGER.error("重定向时出现错误");
        }
        return result;
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @RequestMapping(value = "queryOne/{id}")
    public String queryOneDict(@PathVariable Long id){
        return dictionaryService.queryOne(id).toString();
    }

}
