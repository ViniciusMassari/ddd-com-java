package com.petland.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petland.cadastros.model.entity.ProdutoServicoEntity;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoEntity, Integer> {

}