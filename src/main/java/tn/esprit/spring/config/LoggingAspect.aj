package tn.esprit.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    @Before("execution(* tn.esprit.spring.controller.CrudRestController.*(..))") public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("In method " + name + " : ");
    }
    @After("execution(* tn.esprit.spring.controller.CrudRestController.*(..))") public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();

        logger.info("Out of " + name );
    }
    @Around("execution(* tn.esprit.spring.controller.CrudRestController.*(..))")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        logger.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        return object;
    }
}

