package com.itheima;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String,String> map){
        try {
            SendSmsResponse response = smsUtil.sendSms(map.get("phone"), map.get("signName"), map.get("templateCode"), map.get("Param"));

            System.out.println(response.getCode());
            System.out.println(response.getMessage());
            System.out.println(response.getMessage());
            System.out.println(response.getBizId());

        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
