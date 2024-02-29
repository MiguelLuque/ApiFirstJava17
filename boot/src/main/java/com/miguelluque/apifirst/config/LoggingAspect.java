package com.miguelluque.apifirst.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.miguelluque.apifirst.web..*(..))" +
            " || execution(* com.miguelluque.apifirst.service..*(..))")
    public void applicationPackagePointcut() {
        // Método vacío como marcador - el uso real está en las expresiones pointcut.
    }

    // Definir un advice around que rodea la ejecución de los métodos definidos por el pointcut
    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            logger.info(joinPoint.getSignature() + " ejecutado en " + executionTime + "ms");
        }
    }
}

