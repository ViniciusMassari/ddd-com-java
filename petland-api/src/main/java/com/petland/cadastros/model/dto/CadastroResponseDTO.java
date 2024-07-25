package com.petland.cadastros.model.dto;

import com.petland.cadastros.model.Endereco;
import com.petland.cadastros.model.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroResponseDTO {
    private String nome;
    private Perfil perfil;
    private Endereco endereco;
}
