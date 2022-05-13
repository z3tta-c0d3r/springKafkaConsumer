package com.zeta.springKafka.events;

import com.zeta.springKafka.entity.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteCreatedEvent extends Event<Cliente> {
}