package com.itheima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestSendSms {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void testSendSms(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone","17605080006");
        map.put("signName","黑马程序员");
        map.put("templateCode","SMS_175581479");
        map.put("Param","{\"name\":\"tom\",\"code\":\"123456\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);

    }

}
