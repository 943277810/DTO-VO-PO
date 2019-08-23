package com.bosssoft.hr.train.chp2.aspect;

import com.bosssoft.hr.train.chp2.aspect.annotation.Log;
import com.bosssoft.hr.train.chp2.aspect.bo.LogBO;
import com.bosssoft.hr.train.chp2.aspect.service.LogService;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ztanker
 * @date 2019-07-25 23:46
 * @Description
 */

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.bosssoft.hr.train.chp2.aspect.annotation.Log)")
    public void logPointCut() {}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {

        }
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogBO logBo = new LogBO();
        logBo.setExeuTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logBo.setCreateDate(dateFormat.format(new Date()));
        Log log = method.getAnnotation(Log.class);
        if(log != null){
            logBo.setRemark(log.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logBo.setClassName(className);
        logBo.setMethodName(methodName);
        Object[] args = joinPoint.getArgs();

        try{
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(new Gson().toJson(o));
            }
            logBo.setParams(list.toString());
        }catch (Exception e){ }
        logService.save(logBo);
    }
}
