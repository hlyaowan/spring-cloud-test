package com.demo.cloud.starter.hystrix;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.cloud.starter.client.TestClient;

/**
 * 提供feign方式的ChatLogClient接口熔断
 */
@Slf4j
@Component
public class TestHystrix implements TestClient {
    private final static Logger log = LoggerFactory.getLogger(TestHystrix.class);

    @Override
    public String add(String content) {
        log.error("熔断执行");
        return "熔断执行";
    }
}
