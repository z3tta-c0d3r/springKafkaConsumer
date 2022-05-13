package com.zeta.springKafka.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequestCommand {
    private String name;
    private String email;
}
