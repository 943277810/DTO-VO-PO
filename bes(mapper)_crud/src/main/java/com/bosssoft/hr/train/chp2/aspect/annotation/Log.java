package com.bosssoft.hr.train.chp2.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author ztanker
 * @date 2019-07-25 23:57
 * @Description
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
