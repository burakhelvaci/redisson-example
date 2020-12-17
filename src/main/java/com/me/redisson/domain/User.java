package com.me.redisson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

  @JsonProperty("username")
  private final String username;

  @JsonProperty("fullname")
  private final String fullname;

  @JsonProperty("gsm")
  private final String gsm;

  @JsonProperty("email")
  private final String email;

  @JsonProperty("age")
  private final int age;

  @JsonProperty("password")
  private final String password;

  @JsonCreator
  public User(@JsonProperty("username") String username,
              @JsonProperty("fullname") String fullname,
              @JsonProperty("gsm") String gsm,
              @JsonProperty("email") String email,
              @JsonProperty("age") int age,
              @JsonProperty("password") String password) {
    this.username = username;
    this.fullname = fullname;
    this.gsm = gsm;
    this.email = email;
    this.age = age;
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public String getFullname() {
    return this.fullname;
  }

  public String getGsm() {
    return this.gsm;
  }

  public String getEmail() {
    return this.email;
  }

  public int getAge() {
    return this.age;
  }

  public String getPassword() {
    return this.password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    User user = (User) o;
    return this.age == user.age && this.username.equals(user.username) && this.fullname.equals(user.fullname)
      && this.gsm.equals(user.gsm) && this.email.equals(user.email) && this.password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.username, this.fullname, this.gsm, this.email, this.age, this.password);
  }

  @Override
  public String toString() {
    return "User{" +
      "username='" + this.username + '\'' +
      ", fullname='" + this.fullname + '\'' +
      ", gsm='" + this.gsm + '\'' +
      ", email='" + this.email + '\'' +
      ", age=" + this.age +
      ", password='" + this.password + '\'' +
      '}';
  }
}
