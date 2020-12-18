package com.NetOngs.NetworkFeminino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.NetOngs.NetworkFeminino.model.TemaModel;
import com.NetOngs.NetworkFeminino.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
public class TemaController {
	

	//INJETOU O REPOSITÓRIO DO SERVICO PARA COMUNICAR COM O BANCO DE DADOS
		@Autowired
		private TemaRepository repository;
		
	
		//CRUD
		//CREATE --> POST
		@PostMapping 
		public ResponseEntity<TemaModel> criar(@RequestBody TemaModel tema)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));	
		}
		
		//READ --> GET
		@GetMapping 
		public ResponseEntity<List<TemaModel>> buscarTodos() 
		{		
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity<TemaModel> buscarUm(@PathVariable Long id) 
		{		
			return repository.findById(id)
					.map(temaId -> ResponseEntity.ok(temaId))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping ("/nome/{nome}")
		public ResponseEntity<List<TemaModel>> buscarPorNome(@PathVariable String nome) 
		{		
			return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
		}
		
		//UPDATE --> PUT
		@PutMapping("/{id}")
		public ResponseEntity<TemaModel> atualizar(@PathVariable Long id, @RequestBody TemaModel tema) 
		{
			tema.setId_tema(id);
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
		}
		
		//DELETE --> DELETE
		@DeleteMapping ("/{id}")
		public void remover(@PathVariable Long id) 
		{		
			repository.deleteById(id);
		}
		
}
	
