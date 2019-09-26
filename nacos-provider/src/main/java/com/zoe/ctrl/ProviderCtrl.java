package com.zoe.ctrl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/hi")
    @SentinelResource(value = "hi", blockHandler = "exceptionHandler")
    public String hi(String name) throws InterruptedException {
        Thread.sleep(90);
        LOGGER.info("My name is " + name);
        return "hi " + name + " " + port;
    }

    /**
     *限流与阻塞处理
     * 除了方法名称和参数中多一个异常，其余与原方法一致。
     *@param str 输入参数，ex异常
     *@return java.lang.String 与原方法相同的返回类型。
     */
    public String exceptionHandler(String str, BlockException ex) {
        System.err.println("blockHandler：" + str + ex);
        return "error";
    }
    @RequestMapping(value = "/hi2")
    @ResponseBody()
    public String hi2(String name,String age){
        System.out.println(name);
        System.out.println(age);
        return name;
    }

}
