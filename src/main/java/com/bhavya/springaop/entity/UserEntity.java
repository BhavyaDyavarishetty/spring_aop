package com.bhavya.springaop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  private String name;

  @Basic
  private String city;

  @Basic
  private String country;

}
