package com.anxpp.demo.rabbitmq;

import com.ypp.payment.account.common.dto.request.AccountInfoParam;
import com.ypp.payment.api.client.PaymentClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Resource
	private PaymentClient client;

	@Test
    public void testSign(){
	    client.accountInfo(new AccountInfoParam());
    }

}
