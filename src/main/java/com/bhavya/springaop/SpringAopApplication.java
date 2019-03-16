package com.bhavya.springaop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.*;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableWebMvc
public class SpringAopApplication {

  private static String CREATE_STATEMENT_LOGGER = "create table logger(id integer, details varchar(500), method varchar(50), class_name varchar(50), action_date DATE)";
  private static String CREATE_STATEMENT_USER = "create table user(id integer, name varchar(50), city varchar(50), country varchar(50))";

  @Value("${spring.datasource.username}")
  private static String userName;

  public static void main(String[] args) throws SQLException {
    SpringApplication.run(SpringAopApplication.class, args);
    Connection conn = DriverManager.getConnection("jdbc:h2:mem:", userName, "");
    Statement st = conn.createStatement();
    st.execute(CREATE_STATEMENT_LOGGER);
    st.execute(CREATE_STATEMENT_USER);
  }

}
