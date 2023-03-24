package com.group2.badgeandmembershipsystem.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SaveMemberEvent {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message){
        log.info("Inside send method of SaveMemberEvent");
        kafkaTemplate.send("newMember",message);
    }

}
