package com.NetOngs.NetworkFeminino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NetOngs.NetworkFeminino.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {


	List<TemaModel> findByNomeContainingIgnoreCase(String nome);

}