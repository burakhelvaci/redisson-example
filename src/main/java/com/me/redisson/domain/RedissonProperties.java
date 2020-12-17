package com.me.redisson.domain;

import java.util.Objects;

/**
 * @author Burak Helvacı
 */
public class RedissonProperties {

  private String address;

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    RedissonProperties that = (RedissonProperties) o;
    return Objects.equals(this.address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.address);
  }

  @Override
  public String toString() {
    return "RedissonProperties{" +
      "address='" + this.address + '\'' +
      '}';
  }
}
