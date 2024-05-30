package org.mycompany.servimark.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmail {
    
    @Autowired
    private JavaMailSender mail;

    public ResponseEntity<?> sendEmail(String subject, String message, String to){

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setFrom("servimarkcs@gmail.com");

        email.setSubject(subject);
        email.setText(message);

        mail.send(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
