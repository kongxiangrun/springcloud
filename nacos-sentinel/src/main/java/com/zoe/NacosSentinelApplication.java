package com.zoe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

/**
 * sentinel启动类
 *
 * @author: zoe
 * @date: 2019/9/23 10:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelApplication.class, args);
    }
}
