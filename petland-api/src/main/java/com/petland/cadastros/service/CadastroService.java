package com.petland.cadastros.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.cadastros.repository.CadastroRepository;
import com.petland.cadastros.model.dto.CadastroRequestDTO;
import com.petland.cadastros.model.dto.CadastroResponseDTO;
import com.petland.cadastros.model.entity.CadastroEntity;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public Integer gravar(CadastroRequestDTO requisicao) {
        CadastroEntity entidade = new CadastroEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return repository.save(entidade).getId();
    }

    public Integer alterar(Integer id, CadastroRequestDTO requisicao) {
        CadastroEntity entidade = repository.findById(id).orElse(null);
        if (entidade != null) {
            BeanUtils.copyProperties(requisicao, entidade);
            return repository.save(entidade).getId();
        }
        return null;
    }

    public List<CadastroResponseDTO> listar() {
        List<CadastroEntity> entities = repository.findAll();
        List<CadastroResponseDTO> response = entities.stream().map(
                cadastro -> new CadastroResponseDTO(cadastro.getNome(), cadastro.getPerfil(), cadastro.getEndereco()))
                .collect(Collectors.toList());
        return response;
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}