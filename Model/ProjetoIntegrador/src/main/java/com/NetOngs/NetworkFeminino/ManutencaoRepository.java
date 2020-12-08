package com.NetOngs.NetworkFeminino;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<ModelTema, Long> {
	
	public List<ModelTema> findAllByCategoriaContainingIgnoreCase(String  categoria);
	}
