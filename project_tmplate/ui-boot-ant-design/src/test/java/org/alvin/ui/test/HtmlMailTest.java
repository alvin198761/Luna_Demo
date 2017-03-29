package org.alvin.ui.test;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tangzhichao on 2016/10/25.
 */
public class HtmlMailTest {

//    private static MailConfig createMailConfig() {
//        MailConfig config = new MailConfig();
//        config.setAuth(true);
//        String fromUser = "alvin198761@163.com";
//        config.setFromUser(fromUser);
//        config.setHost("smtp.163.com");
//        String userName = fromUser.substring(0, fromUser.indexOf("@"));
//        config.setSendUserName(userName);
//        config.setSendUserPassword("jinfeng1991");
//        config.setSslEnabled(true);
//        config.setToUsers("2273410177@qq.com".split(","));
//        return config;
//    }
//
//    public static void main(String[] args) throws GeneralSecurityException, MessagingException, IOException {
//
//        MailConfig mailConfig = createMailConfig();
//        // 配置信息
//        Properties pro = new Properties();
//        pro.put("mail.smtp.host", mailConfig.getHost());
//        pro.put("mail.smtp.auth", mailConfig.isAuth());
//        // SSL加密
//        MailSSLSocketFactory sf = new MailSSLSocketFactory();
//        // 设置信任所有的主机
//        sf.setTrustAllHosts(true);
//        pro.put("mail.smtp.ssl.enable", mailConfig.isSslEnabled());
//        pro.put("mail.smtp.ssl.socketFactory", sf);
//        // 根据邮件的会话属性构造一个发送邮件的Session，这里需要注意的是用户名那里不能加后缀，否则便不是用户名了
//        //还需要注意的是，这里的密码不是正常使用邮箱的登陆密码，而是客户端生成的另一个专门的授权码
//        MailAuthenticator authenticator = new MailAuthenticator(mailConfig.getSendUserName(), mailConfig.getSendUserPassword());
//        Session session = Session.getInstance(pro, authenticator);
//        // 根据Session 构建邮件信息
//        Message message = new MimeMessage(session);
//        // 创建邮件发送者地址
//        Address from = new InternetAddress(mailConfig.getFromUser());
//        // 设置邮件消息的发送者
//        message.setFrom(from);
//        // 验证收件人邮箱地址
//        List<String> toAddressList = Arrays.asList(mailConfig.getToUsers());
//        StringBuffer buffer = new StringBuffer();
//        if (!toAddressList.isEmpty()) {
//            String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//            Pattern p = Pattern.compile(regEx);
//            for (int i = 0; i < toAddressList.size(); i++) {
//                Matcher match = p.matcher(toAddressList.get(i));
//                if (match.matches()) {
//                    buffer.append(toAddressList.get(i));
//                    if (i < toAddressList.size() - 1) {
//                        buffer.append(",");
//                    }
//                }
//            }
//        }
//        String toAddress = buffer.toString();
//        if (!toAddress.isEmpty()) {
//            // 创建邮件的接收者地址
//            Address[] to = InternetAddress.parse(toAddress);
//            // 设置邮件接收人地址
//            message.setRecipients(Message.RecipientType.TO, to);
//            // 邮件主题
//            message.setSubject("测试邮件");
//            // 邮件容器
//            MimeMultipart mimeMultiPart = new MimeMultipart();
////            // 设置HTML
//            BodyPart bodyPart = new MimeBodyPart();
//            String content = new String(Files.readAllBytes(Paths.get("D:", "mail1.html")));
////            // 邮件内容
////            // String htmlText = "java邮件测试111";
//            bodyPart.setContent(content, "text/html;charset=utf-8");
//            mimeMultiPart.addBodyPart(bodyPart);
//
////            message.setContent(mimeMultiPart);
////            message.setText(content);
//            message.setSentDate(new Date());
//            // 保存邮件
//            message.saveChanges();
//            // 发送邮件
//            Transport.send(message);
//        }
//
//    }
}
