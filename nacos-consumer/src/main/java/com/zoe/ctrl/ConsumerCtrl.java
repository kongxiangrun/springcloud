package com.zoe.ctrl;

import com.zoe.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者Ctrl
 *
 * @author: zoe
 * @date: 2019/9/20 16:55
 */
@RestController
@RequestMapping("/consumerCtrl")
public class ConsumerCtrl {
    private ConsumerService consumerService;

    @Autowired
    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/get")
    public String get(String name) {
        return consumerService.get(name);
    }
}
