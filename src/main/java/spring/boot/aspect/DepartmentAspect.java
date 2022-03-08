package spring.boot.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class DepartmentAspect {

    Logger logger = Logger.getLogger(DepartmentAspect.class);


    @Before("execution(* findAll(..))")
    public void beforeGettingAnyModel(JoinPoint joinPoint) {
        logger.info("Before: ");
        logger.info("Signature name: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* findAll(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("After: ");
        logger.info(joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* findAll(..))", returning = "result")
    public void afterReturningAnyModel(JoinPoint joinPoint, Object result) {
        logger.info("After result ");
        logger.info(joinPoint.getSignature().getName());
        logger.info("The result is " + result);
    }
}
