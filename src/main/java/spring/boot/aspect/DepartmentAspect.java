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
        logger.info("Before finding all: ");
        logger.info("Signature name: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* delete(..)))")
    public void beforeDeleting(JoinPoint joinPoint) {
        logger.info("Before Delete: ");
        logger.info("Signature name: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* save(..)))")
    public void beforeSaving(JoinPoint joinPoint) {
        logger.info("Before Saving: ");
        logger.info("Signature name: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(* update(..)))")
    public void beforeUpdating(JoinPoint joinPoint) {
        logger.info("Before Updating: ");
        logger.info("Signature name: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* findAll(..))")
    public void afterFindingAnyModel(JoinPoint joinPoint) {
        logger.info("After Finding All: ");
        logger.info(joinPoint.getSignature().getName());
    }

    @After("execution(* delete(..))")
    public void afterDeleting(JoinPoint joinPoint) {
        logger.info("After Deleting: ");
        logger.info(joinPoint.getSignature().getName());
    }

    @After("execution(* save(..))")
    public void afterSaving(JoinPoint joinPoint) {
        logger.info("After Saving: ");
        logger.info(joinPoint.getSignature().getName());
    }

    @After("execution(* update(..))")
    public void afterUpdating(JoinPoint joinPoint) {
        logger.info("After Updating: ");
        logger.info(joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* findAll(..))", returning = "result")
    public void afterReturningAnyModel(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Any Model ");
        logger.info(joinPoint.getSignature().getName());
        logger.info("The result is " + result);
    }

    @AfterReturning(pointcut = "execution(* delete(..))", returning = "result")
    public void afterReturningDelete(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Deleting ");
        logger.info(joinPoint.getSignature().getName());
        logger.info("The result is " + result);
    }

    @AfterReturning(pointcut = "execution(* save(..))", returning = "result")
    public void afterReturningSave(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Saving ");
        logger.info(joinPoint.getSignature().getName());
        logger.info("The result is " + result);
    }

    @AfterReturning(pointcut = "execution(* update(..))", returning = "result")
    public void afterReturningUpdate(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Update ");
        logger.info(joinPoint.getSignature().getName());
        logger.info("The result is " + result);
    }
}
