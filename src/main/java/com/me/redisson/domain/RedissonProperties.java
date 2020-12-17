package com.me.redisson.domain;

import java.util.Objects;

public class RedissonProperties {

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RedissonProperties that = (RedissonProperties) o;
    return Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }

  @Override
  public String toString() {
    return "RedissonProperties{" +
      "address='" + address + '\'' +
      '}';
  }
}
