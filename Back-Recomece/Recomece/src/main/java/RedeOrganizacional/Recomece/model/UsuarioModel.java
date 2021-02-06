package RedeOrganizacional.Recomece.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_Usuário")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	
	@NotNull
	private String nome;
	
	@NotNull
	private String userName;

	
	@NotNull
	private String senha;
	
	
	//////////////////////////////Integração com o Front //////////////////////////////////
	private String foto;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<PostagemModel>postagem2;
	
	
	//////////////////////////////Integração com o Front //////////////////////////////////

	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PostagemModel> postagem;
	
	@OneToMany(mappedBy = "autoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("autoria")
	private List<ComentarioModel> comentario;
	
	/////////////////////////////    CHAVES ESTRANGEIRAS    /////////////////////////////

	
	
	
	
	//Getters and Setters
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

	public List<ComentarioModel> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioModel> comentario) {
		this.comentario = comentario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<PostagemModel> getPostagem2() {
		return postagem2;
	}

	public void setPostagem2(List<PostagemModel> postagem2) {
		this.postagem2 = postagem2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
	
	
}
