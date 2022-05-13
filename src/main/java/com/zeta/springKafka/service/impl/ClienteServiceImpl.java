package com.zeta.springKafka.service.impl;

import com.zeta.springKafka.dto.request.ClienteRequestCommand;
import com.zeta.springKafka.entity.Cliente;

public interface ClienteServiceImpl {
    public Cliente save(ClienteRequestCommand clienteRequestCommand);
}
