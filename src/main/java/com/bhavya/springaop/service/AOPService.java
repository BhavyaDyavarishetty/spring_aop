package com.bhavya.springaop.service;

import org.springframework.stereotype.Service;

@Service
public interface AOPService {

  String getName(Integer id);
}
