package com.NetOngs.NetworkFeminino;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tema")
public class ModelTema {
	
	@Id	
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tema;
	
	@Column
	private String categoria;
	
	@Column
	@NotNull
	private String nome;
	
	@Column
	private int classificacaoIndicativa;

	public Long getId_tema() {
		return id_tema;
	}

	public void setId_tema(Long id_tema) {
		this.id_tema = id_tema;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	//Getters and Setters
}
