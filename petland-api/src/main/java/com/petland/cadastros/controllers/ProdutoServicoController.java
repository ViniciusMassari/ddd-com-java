package com.petland.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.cadastros.model.entity.ProdutoServicoEntity;
import com.petland.cadastros.repository.ProdutoServicoRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/produto")
public class ProdutoServicoController {
    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    @GetMapping
    public List<ProdutoServicoEntity> getProduto() {
        return produtoServicoRepository.findAll();
    }

    @PostMapping
    public String saveProduto(@RequestBody ProdutoServicoEntity produtoServico) {
        produtoServicoRepository.save(produtoServico);
        return produtoServico.getNome();
    }

    @PutMapping("/{id}")
    public String alterarProduto(@PathVariable Integer id, @RequestBody ProdutoServicoEntity produtoServico) {
        var produto = produtoServicoRepository.findById(id);
        return produto.map(product -> {
            product.setNome(produtoServico.getNome());
            product.setServico(produtoServico.getServico());
            product.setValor(produtoServico.getValor());
            return produtoServicoRepository.save(product).getNome();
        }).orElseGet(() -> {
            return produtoServicoRepository.save(produtoServico).getNome();
        });
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Integer id) {
        produtoServicoRepository.deleteById(id);
        return "Deletado";
    }

}
