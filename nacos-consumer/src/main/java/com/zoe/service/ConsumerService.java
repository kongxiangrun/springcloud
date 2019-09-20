package com.zoe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 消费者服务接口
 *
 * @author: zoe
 * @date: 2019/9/20 16:58
 */
@FeignClient(value = "nacos-provider")
public interface ConsumerService {
    /**
     * @param name 姓名
     * @return 结果
     */
    @RequestMapping(value = "/providerCtrl/hi", method = RequestMethod.POST)
    String get(String name);
}
