package com.sjtuse.zcbookstore.helper.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zcoaolas on 2017/5/12.
 */
@Component
@Aspect
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class);
    String logStr = null;

    public void doBefore(JoinPoint jp){
        logStr = "---CLASS--- " + jp.getTarget().getClass().getName() + " ---METHOD---" +
                jp.getSignature().getName() + " *****Start Execution*****";
        logger.info(logStr);
    }

    public void doAfter(JoinPoint jp){
        logStr = "---CLASS--- " + jp.getTarget().getClass().getName() + " ---METHOD---" +
                jp.getSignature().getName() + " *****FinishExecution*****";
        logger.info(logStr);
    }
}
