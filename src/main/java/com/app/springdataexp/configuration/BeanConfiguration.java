package com.app.springdataexp.configuration;

import com.app.springdataexp.redisexp.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Employee> redisTemplate() {
        RedisTemplate<String, Employee> empTemplate = new RedisTemplate<>();
        empTemplate.setConnectionFactory(redisConnectionFactory());
        return empTemplate;
    }
}
