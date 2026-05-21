package com.rays.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Implementation of EmailServiceInt to send emails using JavaMailSender.
 * 
 * @author Akbar Mansuri
 */
@Service
public class EmailServiceImpl implements EmailServiceInt {

    @Autowired
    private JavaMailSender mailSend;

    @Override
    public void sendMail(EmailMessage msg) {

        try {
            MimeMessage mimeMessage = mailSend.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(msg.getTo());
            helper.setSubject(msg.getSubject());

            if (msg.getMessageType() == EmailMessage.HTML_MSG) {
                helper.setText(msg.getMessage(), true); // HTML
            } else {
                helper.setText(msg.getMessage(), false); // TEXT
            }

            mailSend.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}