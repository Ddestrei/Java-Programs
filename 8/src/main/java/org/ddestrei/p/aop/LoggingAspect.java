package org.ddestrei.p.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* org.ddestrei.p..*(..))")
    private void anyPublicMethod(){
    }

    @Before("anyPublicMethod()")
    public void beforeAnyPublicMethod(JoinPoint joinPoint){
        log.info(" Before is working!!! "+ joinPoint.getSignature().getName()  );
    }

    @After("anyPublicMethod()")
    public void afterAnyPublicMethod(JoinPoint joinPoint){
        log.info(" After is working!!! "+ joinPoint.getSignature().getName()  );
    }

    @Around("execution(* org.ddestrei.p.controller.ControllerClass..*(..))")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        log.info(" :: TIME :: "+(System.nanoTime()-start));
        return proceed;
    }
}
