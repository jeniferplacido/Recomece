package com.NetOngs.NetworkFeminino.controller;

import java.util.List;
import java.util.Optional;

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

import com.NetOngs.NetworkFeminino.model.UsuarioModel;
import com.NetOngs.NetworkFeminino.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	
	// INJETOU O REPOSITÓRIO DO SERVICO PARA COMUNICAR COM O BANCO DE DADOS
		@Autowired
		private UsuarioRepository repository;

		// CRUD
		// CREATE --> POST
		@PostMapping
		public ResponseEntity<UsuarioModel> criar(@RequestBody UsuarioModel usuario) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}


		// READ --> GET
		@GetMapping
		public ResponseEntity<List<UsuarioModel>> buscarTodos() {
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<UsuarioModel> buscarUm(@PathVariable Long id) {
			return repository.findById(id).map(usuarioId -> ResponseEntity.ok(usuarioId))
					.orElse(ResponseEntity.notFound().build());
		}

		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<UsuarioModel>> buscarPorNome(@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}

		// UPDATE --> PUT
		@PutMapping("/{id}")
		public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
			usuario.setId_usuario(id);
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}

		// DELETE --> DELETE
		@DeleteMapping("/{id}")
		public void remover(@PathVariable Long id) {
			repository.deleteById(id);
		}

	}
