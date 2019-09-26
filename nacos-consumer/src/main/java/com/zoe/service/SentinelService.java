package com.zoe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * feign做服务通信，调用接口
 *
 * @author: zoe
 * @date: 2019/9/23 15:48
 */
@FeignClient(value = "nacos-sentinel")
public interface SentinelService {
    /***
     *测试
     *@param
     *@return java.lang.String
     */
    @RequestMapping(value = "/testCtrl/hello", method = RequestMethod.POST)
    String get();
}
