package com.NetOngs.NetworkFeminino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.NetOngs.NetworkFeminino.model.TemaModel;
import com.NetOngs.NetworkFeminino.repository.TemaRepository;

@RestController
@RequestMapping("/")
public class TemaController implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Autowired
	private  TemaRepository repository;
	
	@PostMapping("/postar")
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel painel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(painel));
	}
	
	
	@GetMapping("/posts")
	public List<TemaModel> pesquisarTodos() {
		return repository.findAll();
	}
	
	/*@PutMapping("/atualizar/{id}")
	public ModelTema atualizar(@PathVariable List<PostagemModel> id, @RequestBody ModelTema painel) {
		painel.setId_tema(id);
		repository.save(painel);
		return painel;
	}*/
	
	/*
	@PutMapping("/atualizar")
	public ResponseEntity<ModelTema> put(@RequestBody ModelTema postagem) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(postagem));
	}*/
	
	@GetMapping("/postagem/{id}")	
	public ResponseEntity<TemaModel> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String remover(@PathVariable Long id) {
		try {
			repository.deleteById(id);
		return "sucesso";
		}catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<TemaModel>> getByCategory(@PathVariable String categoria) {
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	
	
}
