package com.zoe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置类
 *
 * @author: zoe
 * @date: 2019/9/23 10:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableScheduling
@RefreshScope
public class NacosConfigApplication {
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);

    }

    @RequestMapping("/a")
    public void exec() {
        System.out.println(name);
        System.out.println(age);
    }
}
