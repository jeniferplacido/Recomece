package com.NetOngs.NetworkFeminino;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String nome;
	
	@Column
	private int classificacaoIndicativa;
	

}
