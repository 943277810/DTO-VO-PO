package com.bosssoft.hr.train.chp2.aspect.service;

import com.bosssoft.hr.train.chp2.aspect.bo.LogBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author ztanker
 * @date 2019-07-25 23:51
 * @Description
 */
@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);
    public boolean save(LogBO logBo){
        LOGGER.info(logBo.toString());
        return true;
    }
}
