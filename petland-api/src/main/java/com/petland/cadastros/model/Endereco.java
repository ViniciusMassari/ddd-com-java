package com.petland.cadastros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
    @Column(length = 80)
    private String logradouro;
    @Column(length = 6)
    private String numero;
}
