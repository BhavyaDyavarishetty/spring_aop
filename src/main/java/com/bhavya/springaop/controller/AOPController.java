package com.bhavya.springaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

  @RequestMapping("/")
  public String healthCheck() {
    return "OK";
  }

  @GetMapping("/names/{id}")
  public String getName(@PathVariable Integer id){
    return new String();
  }
}
