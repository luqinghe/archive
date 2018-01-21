package com.luqinghe.entity;

import com.luqinghe.constants.Constants;
import org.apache.commons.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qinghe on 2017/12/27.
 * @author qinghe
 * @date 2017-12-28
 */
public class EmailEntity {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailEntity.class);

    public static void sendSimpleEmail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(Constants.EMAIL_HOST_NAME);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(Constants.EMAIL_ACCOUNT, Constants.EMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        email.setFrom(Constants.EMAIL_FROM);
        email.setSubject("啦啦啦");
        email.setMsg("啦啦啦！！！\n" + "\t啦啦啦啦");
        email.addTo("test@test.com","test");
        email.send();
    }

    public static void sendMultiPartEmail() throws EmailException {
        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Users\\qinghe\\Desktop\\beauty.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of My Love");
        attachment.setName("最漂亮的姑娘.jpg");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(Constants.EMAIL_HOST_NAME);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(Constants.EMAIL_ACCOUNT, Constants.EMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        email.setFrom(Constants.EMAIL_FROM, "鲁庆贺");
        email.setSubject("The most beautiful girl.");
        email.setMsg("Here is the picture of the most beautiful girl.");
        email.addTo("test@test.com","test");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();
    }
}
