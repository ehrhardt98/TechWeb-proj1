package br.edu.Insper;

import java.util.Calendar;

public class Mural {
	private Integer id;
	private String nome;
	private Calendar dataCriacao;
	private Calendar ultimaMod;
	private String estilo;
	private Integer idUsuario;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public void setUltimaMod(Calendar ultimaMod) {
		this.ultimaMod = ultimaMod;
	}
	
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	
	public Calendar getUltimaMod() {
		return ultimaMod;
	}
	
	public String getEstilo() {
		return estilo;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
}
