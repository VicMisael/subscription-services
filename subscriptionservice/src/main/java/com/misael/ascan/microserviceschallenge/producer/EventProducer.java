package com.misael.ascan.microserviceschallenge.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misael.ascan.microserviceschallenge.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventProducer {
    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public boolean sendMessage(Event event) throws JsonProcessingException {
        String eventAsMessage = objectMapper.writeValueAsString(event);
        kafkaTemplate.send(orderTopic, eventAsMessage);

        return true;
    }
}
