package com.zeta.springKafka.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private Long id;
    private String name;
    private String email;
}
