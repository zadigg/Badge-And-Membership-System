package EmailService.controller;

import EmailService.domain.Email;
import EmailService.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<?> send(@RequestBody Email email){
        emailService.sendEmail(email);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }


}
