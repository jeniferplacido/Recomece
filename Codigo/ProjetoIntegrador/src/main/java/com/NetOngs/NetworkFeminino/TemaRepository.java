package com.NetOngs.NetworkFeminino;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD:Model/ProjetoIntegrador/src/main/java/com/NetOngs/NetworkFeminino/ManutencaoRepository.java
public interface ManutencaoRepository extends JpaRepository<ModelTema, Long> {
	
	public List<ModelTema> findAllByCategoriaContainingIgnoreCase(String  categoria);
	}
=======
public interface TemaRepository extends JpaRepository<ModelTema, Long>{
	public List<ModelTema> findAllByCategoriaContainingIgnoreCase(String categoria);
}
>>>>>>> ae6b969c06b266c1458a21c67fa634f03e07b583:Code/ProjetoIntegrador/src/main/java/com/NetOngs/NetworkFeminino/TemaRepository.java
