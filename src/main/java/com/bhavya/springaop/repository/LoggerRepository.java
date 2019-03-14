package com.bhavya.springaop.repository;

import com.bhavya.springaop.entity.LoggerEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<LoggerEntity, Integer> {
}
