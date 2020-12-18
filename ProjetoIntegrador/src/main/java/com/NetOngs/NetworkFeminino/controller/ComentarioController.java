package com.NetOngs.NetworkFeminino.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NetOngs.NetworkFeminino.model.ComentarioModel;
import com.NetOngs.NetworkFeminino.repository.ComentarioRepository;

@RestController
@RequestMapping("/postagens/comentario")
public class ComentarioController {
	
	//INJETOU O REPOSITÓRIO DO SERVICO PARA COMUNICAR COM O BANCO DE DADOS
	@Autowired
	private ComentarioRepository repository;
	

	//CRUD
	//CREATE --> POST
	@PostMapping 
	public ResponseEntity<ComentarioModel> criar(@RequestBody ComentarioModel comentario)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));	
	}
	
	//READ --> GET
	@GetMapping 
	public ResponseEntity<List<ComentarioModel>> buscarTodos() 
	{		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ComentarioModel> buscarUm(@PathVariable Long id) 
	{		
		return repository.findById(id)
				.map(comentarioId -> ResponseEntity.ok(comentarioId))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	//UPDATE --> PUT
	@PutMapping("/{id}")
	public ResponseEntity<ComentarioModel> atualizar(@PathVariable Long id, @RequestBody ComentarioModel comentario) 
	{
		comentario.setId_comentario(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
	}
	
	//DELETE --> DELETE
	@DeleteMapping ("/{id}")
	public void remover(@PathVariable Long id) 
	{		
		repository.deleteById(id);
	}
	

}

	
