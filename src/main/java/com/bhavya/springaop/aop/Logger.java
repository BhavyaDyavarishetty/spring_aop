package com.bhavya.springaop.aop;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(value = RUNTIME)
@Target(METHOD)
@Documented
public @interface Logger {

  String details();
}
