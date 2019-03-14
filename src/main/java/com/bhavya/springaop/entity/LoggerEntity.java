package com.bhavya.springaop.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LoggerEntity {

  private Integer id;
  private String details;
  private String method;
  private String className;
  private Date actionDate;

}
