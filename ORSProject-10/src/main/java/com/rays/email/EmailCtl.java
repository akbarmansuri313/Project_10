package com.rays.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to test sending emails via EmailServiceInt.
 * 
 * @author Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Mail")
public class EmailCtl {

    @Autowired
    private EmailServiceInt emailService;

    @GetMapping("/send")
    public String sendMail() {

        EmailMessage msg = new EmailMessage();

        msg.setTo("shadkhan8516@gmail.com");
        msg.setSubject("Shaad Pd lena");
        msg.setMessage("Email  Send Successfully...!!!");

        emailService.sendMail(msg);

        return "Email service";
    }
}