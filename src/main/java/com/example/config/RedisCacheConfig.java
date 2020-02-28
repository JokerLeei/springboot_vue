/*
package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

// redis 集群缓存配置
@Configuration
public class RedisCacheConfig {
    @Autowired
    @Qualifier(value = "jedisConnectionFactory")
    RedisConnectionFactory conFactory;

    @Bean
    RedisCacheManager redisCacheManager() {
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfig =
                RedisCacheConfiguration.defaultCacheConfig()
                        .prefixKeysWith("sang:")
                        .disableCachingNullValues()
                        .entryTtl(Duration.ofMinutes(30));
        configMap.put("c1", redisCacheConfig);
        RedisCacheWriter cacheWriter =
                RedisCacheWriter.nonLockingRedisCacheWriter(conFactory);

        return new RedisCacheManager(
                cacheWriter,
                // 默认的缓存配置 ↓
                RedisCacheConfiguration.defaultCacheConfig(),
                // 提前定义好的缓存配置 ↓
                configMap
        );
    }
}
*/
