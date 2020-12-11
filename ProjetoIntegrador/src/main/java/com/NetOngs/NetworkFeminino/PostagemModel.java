package com.NetOngs.NetworkFeminino;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Postagem")
public class PostagemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_postagem;

	
	@Column
	private String texto;
	
	@Column
	@Size(min = 5, max = 100)
	private String titulo;
	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private ModelTema postagem;
	public Long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(Long id_postagem) {
		this.id_postagem = id_postagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ModelTema getPostagem() {
		return postagem;
	}

	public void setPostagem(ModelTema postagem) {
		this.postagem = postagem;
	}

	
	
	
	
	
}
