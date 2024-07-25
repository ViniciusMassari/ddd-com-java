package com.petland.cadastros.model.dto;

import java.time.LocalDate;

import com.petland.cadastros.model.AnimalEspecie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalResponseDTO {
    private String nome;
    private LocalDate aniversario;
    private AnimalEspecie especie;

}
