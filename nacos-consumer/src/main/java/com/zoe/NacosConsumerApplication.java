package com.zoe;

import com.zoe.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费者启动类
 *
 * @author: zoe
 * @date: 2019/9/20 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

    private static ConsumerService consumerService;

    private static String rule;
    @Value("${nacos-provider.ribbon.NFLoadBalancerRuleClassName}")
    public  void setRule(String rule) {
        NacosConsumerApplication.rule = rule;
    }

    @Autowired
    public void setConsumerService(ConsumerService consumerService) {
        NacosConsumerApplication.consumerService = consumerService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(NacosConsumerApplication.class, args);
        while (true) {
            System.out.println(rule);
            String zoe = consumerService.get("ZOE");
            System.out.println(zoe);
            Thread.sleep(500);
        }
    }
}
