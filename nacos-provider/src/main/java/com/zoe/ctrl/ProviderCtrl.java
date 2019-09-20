package com.zoe.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 服务提供Ctrl,通过修改配置文件端口号，启动多个实例，消费者消费测试负载均衡。
 *
 * @author: zoe
 * @date: 2019/9/20 16:51
 */
@RestController
@RequestMapping("/providerCtrl")
public class ProviderCtrl {
    @Value("${server.port}")
    private int port;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderCtrl.class);

    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    public String hi(@RequestBody String name) {
        LOGGER.info("My name is "+name);
        return "hi " + name + " " + port;
    }
}
