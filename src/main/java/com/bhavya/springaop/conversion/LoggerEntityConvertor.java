package com.bhavya.springaop.conversion;

import com.bhavya.springaop.dto.LoggerTypeEnum;
import com.bhavya.springaop.entity.LoggerEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoggerEntityConvertor {

  public LoggerEntity convert(String details, String methodName, String className, LoggerTypeEnum type){

    LoggerEntity loggerEntity = new LoggerEntity();
    loggerEntity.setType(type.getType());
    loggerEntity.setMethod(methodName);
    loggerEntity.setClassName(className);
    loggerEntity.setDetails(details);
    loggerEntity.setActionDate(new Date());
    return loggerEntity;
  }
}
