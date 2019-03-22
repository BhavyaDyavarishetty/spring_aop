package com.bhavya.springaop.aop;

import com.bhavya.springaop.conversion.LoggerEntityConverter;
import com.bhavya.springaop.dto.LoggerTypeEnum;
import com.bhavya.springaop.entity.LoggerEntity;
import com.bhavya.springaop.repository.LoggerRepository;
import com.sun.deploy.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

  @Autowired private LoggerRepository loggerRepository;

  @Autowired private LoggerEntityConverter loggerEntityConverter;

  @Before("@annotation(com.bhavya.springaop.aop.Logger)")
  public void beforeMethod(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();
    String args = StringUtils.join(Arrays.asList(joinPoint.getArgs()), ",");

    LoggerEntity loggerEntity = loggerEntityConverter.convert(args, methodName, className, LoggerTypeEnum.LOG);
    loggerRepository.save(loggerEntity);
  }

  @AfterReturning(pointcut = "@annotation(com.bhavya.springaop.aop.Logger)", returning = "result")
  public void afterReturnMethod(JoinPoint joinPoint, Object result) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();

    LoggerEntity loggerEntity = loggerEntityConverter.convert(result.toString(), methodName, className, LoggerTypeEnum.LOG);
    loggerRepository.save(loggerEntity);
  }
  
  @AfterThrowing(pointcut = "@annotation(com.bhavya.springaop.aop.Logger)", throwing = "error")
  public void afterThrowingMethod(JoinPoint joinPoint, Throwable error) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();

    LoggerEntity loggerEntity = loggerEntityConverter.convert(error.getMessage(), methodName, className,
        LoggerTypeEnum.ERROR);
    loggerRepository.save(loggerEntity);
  }
}
