package com.zzl.service.impl;

import com.zzl.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImp implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from="3490596334@qq.com";
    //接收人
    private String to="3490596334@qq.com";
    //标题
    private String title="darling";

    //内容
    private String content="298320";

    @Override
    public void sendMail() {

        SimpleMailMessage message=new SimpleMailMessage();
//        message.setFrom(from+"(你爹)");
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        //定时发送
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println("定时设置为:"+simpleDateFormat.format(date));
//        message.setSentDate(date);


        javaMailSender.send(message);

    }
}
