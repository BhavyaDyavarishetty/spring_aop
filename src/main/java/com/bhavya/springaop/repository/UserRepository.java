package com.bhavya.springaop.repository;

import com.bhavya.springaop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
