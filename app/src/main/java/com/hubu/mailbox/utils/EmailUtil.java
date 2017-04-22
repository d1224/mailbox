package com.hubu.mailbox.utils;

import android.content.Context;
import android.util.Log;

import com.hubu.mailbox.bean.MailSenderInfo;

public class EmailUtil {
    public static void autoSendMail(Context context, String msuggestions) {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");//smtp地址
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("13971024963@163.com");//邮箱名字
        mailInfo.setPassword("dy33189786");// 邮箱密码
        mailInfo.setFromAddress("13971024963@163.com");// 发送方邮件地址
        mailInfo.setToAddress("13971024963@163.com");//接受方邮件地址
        mailInfo.setSubject("毕业设计第一次尝试");
        mailInfo.setContent(msuggestions + "\n毕业设计第一次尝试");
        // 这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);// 发送文体格式
        Log.e("------->", msuggestions);
        // sms.sendHtmlMail(mailInfo);// 发送html格式
    }
}
