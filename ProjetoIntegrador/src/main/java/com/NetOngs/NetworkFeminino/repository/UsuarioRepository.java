package com.NetOngs.NetworkFeminino.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NetOngs.NetworkFeminino.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long> {
		public List<UsuarioModel> findAllBynomeUsuarioContainingIgnoreCase(String nomeUsuario);
	}

