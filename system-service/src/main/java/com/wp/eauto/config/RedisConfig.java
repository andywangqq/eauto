package com.wp.eauto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String,Object>template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(factory);
//        // 设置Key序列化格式
//        template.setKeySerializer(RedisSerializer.string());
//        // 设置value序列化格式
//        template.setValueSerializer(RedisSerializer.json());
//        // 设置hase的key序列化格式
//        template.setHashKeySerializer(RedisSerializer.string());
//        // 设置hase的value序列化格式
//        template.setHashValueSerializer(RedisSerializer.json());
//        template.afterPropertiesSet();
//        return template;
//
//    }
}
