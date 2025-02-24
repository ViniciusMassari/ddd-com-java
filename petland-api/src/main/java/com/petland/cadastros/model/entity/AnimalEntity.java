package com.petland.cadastros.model.entity;

import java.time.LocalDate;

import com.petland.cadastros.model.AnimalEspecie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tab_animal")
@Data
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    private LocalDate aniversario;

    @Enumerated(EnumType.STRING)
    private AnimalEspecie especie;

    @Column(name = "cad_tutor")
    private Integer tutor;

}
