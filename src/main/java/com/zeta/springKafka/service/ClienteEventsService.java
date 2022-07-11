package com.zeta.springKafka.service;

import com.zeta.springKafka.entity.Cliente;
import com.zeta.springKafka.events.ClienteCreatedEvent;
import com.zeta.springKafka.events.Event;
import com.zeta.springKafka.events.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@Slf4j
public class ClienteEventsService extends Event<Cliente>{

    @KafkaListener(topics = "${topic.cliente.name:test}", containerFactory = "kafkaListenerContainerFactory", groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(ClienteCreatedEvent.class)) {
            ClienteCreatedEvent customerCreatedEvent = (ClienteCreatedEvent) event;
            log.info("Received customerCreatedEvent .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }

    }
}
