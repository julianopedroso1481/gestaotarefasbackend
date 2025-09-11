package br.com.gestaotarefas.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.ToString;


@ToString
public class RequestTarefaDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String titulo;
	private String descricao;
	private String status;
	private Date dataCriacao;	
	
	
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
	    return "RequestTarefaDTO [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao +
	           ", status=" + status + ", dataCriacao=" + dataCriacao + "]";
	}
}