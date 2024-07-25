package com.petland.cadastros.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalRequestDTO extends AnimalResponseDTO {
    private Integer tutor;
}