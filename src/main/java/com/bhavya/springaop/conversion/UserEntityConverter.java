package com.bhavya.springaop.conversion;

import com.bhavya.springaop.dto.User;
import com.bhavya.springaop.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

  public UserEntity convert(User user){
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user, userEntity);
    return userEntity;
  }
}
