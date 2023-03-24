package EmailService.service;

import EmailService.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Value("${email.from-address}")
    private String FROM_ADDRESS;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(FROM_ADDRESS);
            message.setTo(email.getReceiverEmail());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            javaMailSender.send(message);
        } catch (MailException mailException) {
            mailException.printStackTrace();
        }

    }
}
