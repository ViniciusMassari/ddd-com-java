package com.petland.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.atendimento.dto.AtendimentoRequestDTO;
import com.petland.atendimento.service.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @PostMapping()
    public Integer gravar(@RequestBody AtendimentoRequestDTO requisicao) {
        return service.gravar(requisicao);
    }
}