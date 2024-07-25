package com.petland.cadastros.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.cadastros.repository.AnimalRepository;
import com.petland.cadastros.model.dto.AnimalRequestDTO;
import com.petland.cadastros.model.dto.AnimalResponseDTO;
import com.petland.cadastros.model.entity.AnimalEntity;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Integer gravar(AnimalRequestDTO requisicao) {
        AnimalEntity entidade = new AnimalEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return animalRepository.save(entidade).getId();
    }

    public Integer alterar(Integer id, AnimalRequestDTO requisicao) {
        AnimalEntity entidade = animalRepository.findById(id).orElse(null);
        if (entidade != null) {
            BeanUtils.copyProperties(requisicao, entidade);
            return animalRepository.save(entidade).getId();
        }
        return null;
    }

    public List<AnimalResponseDTO> list() {
        List<AnimalEntity> entities = animalRepository.findAll();

        List<AnimalResponseDTO> response = entities.stream()
                .map(animal -> new AnimalResponseDTO(animal.getNome(), animal.getAniversario(), animal.getEspecie()))
                .collect(Collectors.toList());

        return response;
    }

    public void excluir(Integer id) {
        animalRepository.deleteById(id);
    }

}
