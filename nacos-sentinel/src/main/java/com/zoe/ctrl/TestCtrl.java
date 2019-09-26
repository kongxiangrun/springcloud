package com.zoe.ctrl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Ctrl
 *
 * @author: zoe
 * @date: 2019/9/23 14:51
 */
@RestController
@RequestMapping(value = "/testCtrl")
public class TestCtrl {

    @RequestMapping(value = "/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hello Sentinel";
    }
}