package com.petland.cadastros.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.petland.cadastros.service.AnimalService;
import com.petland.cadastros.model.dto.AnimalRequestDTO;
import com.petland.cadastros.model.dto.AnimalResponseDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping
    public List<AnimalResponseDTO> getAnimals() {
        return animalService.list();
    }

    @PostMapping()
    public Integer gravar(@RequestBody AnimalRequestDTO requisicao) {
        return animalService.gravar(requisicao);
    }

    @PutMapping("/{id}")
    public Integer alterar(@PathVariable Integer id,
            @RequestBody AnimalRequestDTO requisicao) {
        return animalService.alterar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        animalService.excluir(id);
    }
}
