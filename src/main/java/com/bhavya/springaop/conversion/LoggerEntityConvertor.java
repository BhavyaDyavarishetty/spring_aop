package com.bhavya.springaop.conversion;

import com.bhavya.springaop.aop.Logger;
import com.bhavya.springaop.entity.LoggerEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoggerEntityConvertor {

  public LoggerEntity convert(Logger logger, String methodName, String className){

    LoggerEntity loggerEntity = new LoggerEntity();
    loggerEntity.setMethod(methodName);
    loggerEntity.setClassName(className);
    loggerEntity.setDetails(logger.details());
    loggerEntity.setActionDate(new Date());
    return loggerEntity;
  }
}
