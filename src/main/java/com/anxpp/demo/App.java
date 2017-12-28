package com.anxpp.demo;

import com.ypp.payment.message.receiver.handler.DiamondVipChange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public DiamondVipChange handler() {
        return entity -> {
            // 此处 body 即为钻石VIP等级变更消息的新消息体
            // 请在此处实现该消息的处理逻辑
        };
    }
}
