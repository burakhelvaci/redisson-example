package com.me.redisson.config;

import com.me.redisson.domain.RedissonProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Burak Helvacı
 */
@Configuration
public class BeanConfig {

  @Bean
  @ConfigurationProperties("redis.redisson")
  public RedissonProperties redissonProperties() {
    return new RedissonProperties();
  }

  @Bean
  public RedissonClient redissonClient(RedissonProperties redissonProperties) throws IOException {
    Config config = new Config();
    config.useSingleServer().setAddress(redissonProperties.getAddress());
    System.out.println(config.toJSON());
    System.out.println(config.toYAML());
    return Redisson.create();
  }
}
