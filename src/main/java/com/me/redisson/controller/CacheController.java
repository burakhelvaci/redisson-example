package com.me.redisson.controller;

import com.me.redisson.domain.User;
import org.redisson.api.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Burak Helvacı
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

  private final RedissonClient redissonClient;
  private final RMap<String, User> rMap;
  private final RLocalCachedMap<String, User> rLocalCachedMap;
  private final RMapCache<String, User> rMapCache;

  public CacheController(RedissonClient redissonClient) {
    this.redissonClient = redissonClient;
    this.rMap = redissonClient.getMap("user");
    this.rLocalCachedMap = redissonClient.getLocalCachedMap("user", LocalCachedMapOptions.defaults());
    this.rMapCache = redissonClient.getMapCache("user");
  }

  @PostMapping("get-user-with-rmap")
  public User getUserWithRMap(@RequestParam("username") String username) {
    return this.rMap.get(username);
  }

  @PostMapping("get-user-with-rlocalcachedmap")
  public User getUserWithRLocalCachedMap(@RequestParam("username") String username) {
    return this.rLocalCachedMap.get(username);
  }

  @PostMapping("get-user-with-rmapcache")
  public User getUserWithRMapCache(@RequestParam("username") String username) {
    return this.rMapCache.get(username);
  }

  @PostMapping("add-user-with-rmap")
  public void addUserWithRMap(@RequestBody User user) {
    //User previousValue = this.rMap.put(user.getUsername(), user); / returns previous value if exist otherwise null
    this.rMap.fastPut(user.getUsername(), user);
  }

  @PostMapping("add-user-rlocalcachedmap")
  public void addUserWithRLocalCachedMap(@RequestBody User user) {
    //User previousValue = this.rLocalCachedMap.put(user.getUsername(), user); // returns previous value if exist otherwise null
    this.rLocalCachedMap.fastPut(user.getUsername(), user);
  }

  @PostMapping("add-user-with-rmapcache")
  public void addUserRMapCache(@RequestBody User user) {
    //User previousValue = this.rMapCache.put(user.getUsername(), user); // returns previous value if exist otherwise null
    this.rMapCache.fastPut(user.getUsername(), user);
  }
}
