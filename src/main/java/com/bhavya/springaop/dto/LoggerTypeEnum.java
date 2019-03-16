package com.bhavya.springaop.dto;

import lombok.Getter;

public enum LoggerTypeEnum {
  ERROR("error"), LOG("log");

  private @Getter String type;
  LoggerTypeEnum(String type) {
    this.type = type;
  }
}
