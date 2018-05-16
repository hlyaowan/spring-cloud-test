package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import spring.cloud.evnet.PublishEvent;

/**
 * Created by apple on 2018/1/10.
 * 事件监听
 */
@Slf4j
@RefreshScope
@Component
public class TestEventListener implements ApplicationListener<PublishEvent> {
    private final static Logger log = LoggerFactory.getLogger(TestEventListener.class);
    @Override
    public void onApplicationEvent(PublishEvent publishEvent) {
       log.info(publishEvent.getMessage());
    }
}
