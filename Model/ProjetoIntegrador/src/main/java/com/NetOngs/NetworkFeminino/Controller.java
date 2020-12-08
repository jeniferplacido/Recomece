package com.NetOngs.NetworkFeminino;
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
	import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	
	@RestController
	@RequestMapping("/") 
	public class Controller implements WebMvcConfigurer{
		
		
		public void addViewControllers(ViewControllerRegistry index) {
			index.addViewController("/").setViewName("forward:/index.html");
		}
		
			@Autowired
			private ManutencaoRepository repository;
			
			
						
			@PostMapping("/postagem")
			public ResponseEntity<ModelTema> post(@RequestBody ModelTema tabela){
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tabela
						));
			}
			
			@GetMapping("/getAll")
			public List<ModelTema> pesquisarTodos(){
				return repository.findAll();
			}
					
						
			@GetMapping("/getById/{id}")
			public ResponseEntity<ModelTema> GetById(@PathVariable Long id){
				return repository.findById(id)
						.map(resp -> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
						
			}
			@PutMapping("/put/{id}")
			public ModelTema atualizar(@PathVariable Long id, @RequestBody ModelTema tabela) {
				tabela.setId_tema(id);
				repository.save(tabela);
				return tabela;
			}
			@DeleteMapping("/delete/{id}")
			public String remover(@PathVariable Long id) {
				try{
					repository.deleteById(id);
					return "sucesso";
					}catch(Exception e) {
						return "Erro: " + e.getMessage();
					}
				}
			}
			
		



