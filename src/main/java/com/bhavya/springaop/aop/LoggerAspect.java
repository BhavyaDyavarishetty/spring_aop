package com.bhavya.springaop.aop;

import com.bhavya.springaop.conversion.LoggerEntityConvertor;
import com.bhavya.springaop.entity.LoggerEntity;
import com.bhavya.springaop.repository.LoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggerAspect {

  @Autowired private LoggerRepository loggerRepository;

  @Autowired private LoggerEntityConvertor loggerEntityConvertor;

  @After("@annotation(Logger)")
  public void afterReturnMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
    String methodName =  signature.getMethod().getName();
    String className = signature.getMethod().getDeclaringClass().getName();
    Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();


    Logger logger =
        proceedingJoinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getAnnotation(Logger.class);

    LoggerEntity loggerEntity = loggerEntityConvertor.convert(logger, methodName, className);
    loggerRepository.save(loggerEntity);

  }
}
