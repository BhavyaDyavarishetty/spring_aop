package com.bhavya.springaop.service;

import com.bhavya.springaop.aop.Logger;
import com.bhavya.springaop.dto.User;
import com.bhavya.springaop.entity.UserEntity;
import com.bhavya.springaop.exception.ObjectNotFoundException;
import com.bhavya.springaop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Logger
  public UserEntity getUser(Integer id) throws ObjectNotFoundException {
    if(userRepository.findById(id).isPresent()){
      return userRepository.findById(id).get();
    }
    throw new ObjectNotFoundException("User is not found for id " +id);
  }

  @Transactional
  public void createUser(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setName(user.getName());
    userEntity.setCity(user.getCity());
    userEntity.setCountry(user.getCountry());
    userRepository.save(userEntity);
  }
}
