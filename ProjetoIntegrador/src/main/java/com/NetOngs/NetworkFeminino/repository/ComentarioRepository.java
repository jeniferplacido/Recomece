package com.NetOngs.NetworkFeminino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NetOngs.NetworkFeminino.model.ComentarioModel;

	@Repository
	public interface ComentarioRepository extends JpaRepository<ComentarioModel, Long>{
	}
