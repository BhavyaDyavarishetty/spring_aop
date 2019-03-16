package com.bhavya.springaop.aop;

import com.bhavya.springaop.conversion.LoggerEntityConvertor;
import com.bhavya.springaop.dto.LoggerTypeEnum;
import com.bhavya.springaop.entity.LoggerEntity;
import com.bhavya.springaop.repository.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

  @Autowired private LoggerRepository loggerRepository;

  @Autowired private LoggerEntityConvertor loggerEntityConvertor;

  @AfterReturning(pointcut = "@annotation(com.bhavya.springaop.aop.Logger)", returning = "result")
  public void afterReturnMethod(JoinPoint joinPoint, Object result) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();

    LoggerEntity loggerEntity = loggerEntityConvertor.convert(result.toString(), methodName, className, LoggerTypeEnum.LOG);
    loggerRepository.save(loggerEntity);
  }
  
  @AfterThrowing(pointcut = "@annotation(com.bhavya.springaop.aop.Logger)", throwing = "error")
  public void afterThrowingMethod(JoinPoint joinPoint, Throwable error) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();

    LoggerEntity loggerEntity = loggerEntityConvertor.convert(error.getMessage(), methodName, className,
        LoggerTypeEnum.ERROR);
    loggerRepository.save(loggerEntity);
  }
}
