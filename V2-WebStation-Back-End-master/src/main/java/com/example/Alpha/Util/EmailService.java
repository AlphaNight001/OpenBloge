package com.example.Alpha.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmailService {
    private static ConcurrentHashMap<String, VerificationCode> codeMap = new ConcurrentHashMap<>();
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationCode(String toAddress, String verificationCode) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("alphaofpersonalblog@outlook.com");
        helper.setTo(toAddress);
        helper.setSubject("Alpha的个人博客注册系统");
        helper.setText("您的验证码是:"+verificationCode+"\n"+"请勿告知他人，有效期为1分钟！！");
        javaMailSender.send(message);
    }


    public void delateCode(String email) {
        codeMap.remove(email);
    }

    public void putCode(String email, String code) {
        long createTime = System.currentTimeMillis();
        VerificationCode verificationCode = new VerificationCode(code, createTime);
        codeMap.put(email, verificationCode);
    }

    public VerificationCode getCode(String email) {
        return codeMap.get(email);
    }


//    内部类
    public static class VerificationCode {
        private String code;
        private long createTime;

        public VerificationCode(String code, long createTime) {
            this.code = code;
            this.createTime = createTime;
        }

        public String getCode() {
            return code;
        }

        public long getCreateTime() {
            return createTime;
        }
    }


}
