/*
package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

*/
/*Redis 集群配置类。*//*

@Configuration
@ConfigurationProperties("spring.redis.cluster")
public class RedisConfig {
    // 集群端口号数组
    List<Integer> ports;
    // 集群主机
    String host;
    // 连接池配置信息
    JedisPoolConfig poolConfig;

    @Bean
    RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        List<RedisNode> nodes=new ArrayList<>();
        for(Integer port:ports){
            nodes.add(new RedisNode(host,port));
        }
        // Redis 登录密码
        configuration.setPassword(RedisPassword.of("123@456"));
        // Redis 节点信息
        configuration.setClusterNodes(nodes);
        return configuration;
    }

    // 根据 RedisClusterConfiguration 实例以及连接池配置信息创建 Jedis 连接工厂 JedisConnectionFactory
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory(redisClusterConfiguration(),poolConfig);
    }

    // 根据 JedisConnectionFactory 创建 RedisTemplate 和 StringRedisTemplate，同时配置key和value的序列化方式
    @Bean
    RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate;
    }

    @Bean
    StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory());
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
        return stringRedisTemplate;
    }


    public List<Integer> getPorts() {
        return ports;
    }

    public void setPorts(List<Integer> ports) {
        this.ports = ports;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public JedisPoolConfig getPoolConfig() {
        return poolConfig;
    }

    public void setPoolConfig(JedisPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }
}
*/
