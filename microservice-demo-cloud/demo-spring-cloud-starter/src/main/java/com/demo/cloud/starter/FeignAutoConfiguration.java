package com.demo.cloud.starter;

import com.demo.cloud.starter.hystrix.TestHystrix;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.demo.cloud.starter.client"})
public class FeignAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(TestHystrix.class)
    public TestHystrix chatLogClient() {
        return new TestHystrix();
    }

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/1 * 1000, /** readTimeoutMillis **/1 * 1000);
    }

    @Bean
    Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
//        NONE：不记录任何信息
//        BASIC：仅记录请求方法、URL以及响应状态码和执行时间
//        HEADERS：BASIC信息加上请求和响应的头信息
//        FULL：记录所有请求与响应的明细，包括头信息、请求体、元数据等。
        return Logger.Level.FULL;
    }
}
