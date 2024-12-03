package ru.alex.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alex.service.HttpLogger;

@Aspect
@Component
public class MainAspect {
    private final HttpLogger logger;

    @Autowired
    public MainAspect(HttpLogger logger) {
        this.logger = logger;
    }

    @Before("@annotation(LogExecution)")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method was called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "@annotation(GetterExecution)", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        logger.info("Returned from: " + joinPoint.getSignature().getName() + " with value: " + result);
    }

    @AfterThrowing("@annotation(ErrorExecution)")
    public void logError(JoinPoint joinPoint) {
        logger.error("Incorrect userId from: " + joinPoint.getSignature().getName());
    }
}
