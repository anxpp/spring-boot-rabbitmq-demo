package com.anxpp.demo;

import com.ypp.payment.account.common.helper.JsonHelper;
import com.ypp.payment.message.receiver.handler.DiamondVipChange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@EnableFeignClients(basePackages = "com")
@SpringCloudApplication
@ComponentScan("com")
public class App {

    @Resource
    private JsonHelper jsonHelper;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public DiamondVipChange handler() {
        return entity -> {
            // 此处 body 即为钻石VIP等级变更消息的新消息体
            // 请在此处实现该消息的处理逻辑
            System.out.println(jsonHelper.string(entity));
        };
    }
}
