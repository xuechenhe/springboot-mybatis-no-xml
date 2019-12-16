package com.dh;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
public class EnhanceAspect {
    /**
     * 切点
     *
     * @param zodiacName
     */
    @Pointcut("@annotation(com.dh.annotation.EnhanceAnnotation) && args(zodiacName,..)")
    public void pointcut(String zodiacName) {

    }

    @Before(value = "pointcut(zodiacName)")
    public void enhance(String zodiacName) {

        if (zodiacName == null) {
            System.err.println("zodiacName参数丢失");
        }
        if (zodiacName != null) {
            if ("".equals(zodiacName)) {
                System.err.println("zodiacName参数存在但值为空字符串");
            }
            if (!"".equals(zodiacName)) {
                System.err.println("zodiacName参数存且已赋非空字符串值");
            }
        }
    }
}
