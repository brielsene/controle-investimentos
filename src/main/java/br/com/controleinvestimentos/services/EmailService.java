package br.com.controleinvestimentos.services;

import br.com.controleinvestimentos.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendEmail(EmailModel emailModel){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(emailModel.getMessageBody());
        simpleMailMessage.setTo(emailModel.getEmailTo());
        simpleMailMessage.setSubject(emailModel.getSubject());
        simpleMailMessage.setFrom(sender);

        javaMailSender.send(simpleMailMessage);
    }
}
