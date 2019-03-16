package com.bhavya.springaop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "logger")
public class LoggerEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  private String details;

  @Basic
  private String method;

  @Column(name = "class_name")
  private String className;

  @Column(name = "action_date")
  private Date actionDate;

}
