package com.bo.demo.service;

import com.bo.demo.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Resource
    public MailService mailService;
    @Test
    public void HelloTets(){
        mailService.sayHello();
    }

    @Test
    public void sendSimpleMailTest(){
        mailService.sendSimpleMail("602505401@qq.com","自动邮件","你好!");
    }
}
