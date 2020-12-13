package com.NetOngs.NetworkFeminino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NetOngs.NetworkFeminino.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	public List<TemaModel> findAllByCategoriaContainingIgnoreCase(String categoria);
}