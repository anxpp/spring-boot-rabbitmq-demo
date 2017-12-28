package com.anxpp.demo;

import com.ypp.payment.account.common.dto.response.VipDiamondChangeBody;
import com.ypp.payment.message.receiver.handler.DiamondVipChange;
import org.springframework.stereotype.Component;

//@Component
public class DiamondVipChangeHandler implements DiamondVipChange {

    @Override
    public void handle(VipDiamondChangeBody body) {
        // 此处 body 即为钻石VIP等级变更消息的新消息体
        // 请在此处实现该消息的处理逻辑
    }
}