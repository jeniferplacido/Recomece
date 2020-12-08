package com.NetOngs.NetworkFeminino;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Usuario")
public class ProjetoIntegradoModel {

	
							//TABELA DO USUÁRIO
	
	//Colunas
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column
	@NotNull
	private String nomeUsuario;
	
	@Column
	private String apelidoUsuario;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String senha;
	
	@Column
	private String documento;
	
	@Column
	private String sexo;

	
	
	//Getters And Setters
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getApelidoUsuario() {
		return apelidoUsuario;
	}

	public void setApelidoUsuario(String apelidoUsuario) {
		this.apelidoUsuario = apelidoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
