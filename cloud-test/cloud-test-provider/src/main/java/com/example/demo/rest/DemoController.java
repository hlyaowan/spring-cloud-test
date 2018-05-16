package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import spring.cloud.api.client.DemoClient;

/**
 * Created by apple on 2017/12/7.
 */
@Slf4j
@RestController
public class DemoController implements DemoClient {
    private final static Logger log = LoggerFactory.getLogger(DemoController.class);

    @Override
    public String in() {
        log.error("p测试错误");
        log.info("p测试info输出");
        log.debug("p测试debug输出");
        return "调用in()成功";
    }
}
