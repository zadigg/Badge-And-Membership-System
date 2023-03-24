package EmailService.integration;

import EmailService.domain.Email;
import EmailService.dto.RegistrationMessageDTO;
import EmailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NewMemberListener {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = {"newMember"})
    public void listenWhenMemberAdded(@Payload String memberDTO) {

        memberDTO = memberDTO.substring(1, memberDTO.length() - 1);

        System.out.println("Inside Kafka listener Received new member details ...." );
        try {
            System.out.println("Received new member details ....");
            RegistrationMessageDTO messageMemberDetails = new RegistrationMessageDTO(memberDTO.replace("'", "\""));
            System.out.println("message sent to a member with name = "+ messageMemberDetails.getFirstName());

            String body = "WELCOME TO MAHARISHI INTERNATIONAL UNIVERSITY APPLICATION  \n" +
                    "Your are officially a member of our University and you have been successfully added to our system." + "" +
                    " Thank you for choosing our university!\n" + "" +
                    "email:  " + messageMemberDetails.getEmailAddress() + "   \n" +
                    "password:   " + messageMemberDetails.getPassword() + "  " + "\n"+

                   "" + "Sincerely,\n" + "The University Team";


            Email email = new Email(messageMemberDetails.getEmailAddress(), "Welcome to MIU University Application", body);
            emailService.sendEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
