package com.demo.server;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
@Configuration
@EnableAsync //启用异步
@EntityScan({"com.demo.common.*"})
//@EnableJpaRepositories({"com.demo.core.repository.*"}) #单数据源可以使用此配置指定repository位置
@ComponentScan({"com.demo"})
@EnableDubboConfiguration
public class DemoDubboServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoDubboServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }
}