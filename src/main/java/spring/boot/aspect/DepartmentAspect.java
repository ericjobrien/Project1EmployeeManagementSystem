package spring.boot.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DepartmentAspect {

    Logger logger = Logger.getLogger(DepartmentAspect.class);


    @Before("execution(* getAllDepartments*(..))")
    public void BeforeGettingDepartments(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature());
    }
}
