package com.bhavya.springaop.controller;

import com.bhavya.springaop.dto.User;
import com.bhavya.springaop.exception.ObjectNotFoundException;
import com.bhavya.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String healthCheck() {
    return "OK";
  }

  @GetMapping("/users/{id}")
  public String getUser(@PathVariable Integer id) throws ObjectNotFoundException {
    return userService.getUser(id).getName();
  }

  @PostMapping("/user")
  public void createUser(@RequestBody User user){
    userService.createUser(user);
  }
}
