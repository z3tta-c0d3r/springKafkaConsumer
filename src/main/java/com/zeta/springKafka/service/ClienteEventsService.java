package com.zeta.springKafka.service;

import com.zeta.springKafka.entity.Cliente;
import com.zeta.springKafka.events.ClienteCreatedEvent;
import com.zeta.springKafka.events.Event;
import com.zeta.springKafka.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class ClienteEventsService extends Event<Cliente>{
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.cliente.name}")
    private String topicCliente;

    public void publish(Cliente cliente) {

        ClienteCreatedEvent created = new ClienteCreatedEvent();
        created.setData(cliente);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(LocalDate.now());

        this.producer.send(topicCliente, created);
    }
}
