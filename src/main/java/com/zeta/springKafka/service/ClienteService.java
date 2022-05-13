package com.zeta.springKafka.service;

import com.zeta.springKafka.dto.request.ClienteRequestCommand;
import com.zeta.springKafka.entity.Cliente;
import com.zeta.springKafka.service.impl.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteEventsService clienteEventsService;

    public Cliente save(ClienteRequestCommand clienteRequestCommand) {

        Cliente cliente = Cliente.builder().build();
        BeanUtils.copyProperties(clienteRequestCommand,cliente);
        logger.debug("Received {}", cliente);
        this.clienteEventsService.publish(cliente);
        return cliente;

    }
}
