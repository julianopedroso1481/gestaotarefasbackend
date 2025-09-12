package br.com.gestaotarefas.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "TAREFA")
public class TarefaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREFA")
	private Long id;
	@Column(name = "TITULO", length = 200, nullable = false, unique = false)
	private String titulo;
	@Column(name = "DESCRICAO", length = 500)
	private String descricao;
	@Column(name = "STATUS", length = 20)
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;
	@ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "ID_PROJETO") 
    private ProjetoModel projeto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public ProjetoModel getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoModel projeto) {
		this.projeto = projeto;
	}
	
	
	
}
