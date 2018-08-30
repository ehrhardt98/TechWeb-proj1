package br.edu.Insper;


public class Nota {
	private Integer id;
	private String tipo;
	private String conteudo;
	private String cor;
	private Float tamanhoX;
	private Float tamanhoY;
	private Integer idMural;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setTamanhoX(Float tamanhoX) {
		this.tamanhoX = tamanhoX;
	}
	
	public void setTamanhoY(Float tamanhoY) {
		this.tamanhoY = tamanhoY;
	}
	
	public void setIdMural(Integer idMural) {
		this.idMural = idMural;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public Float getTamanhoX() {
		return tamanhoX;
	}
	
	public Float getTamanhoY() {
		return tamanhoY;
	}
	
	public Integer getIdMural() {
		return idMural;
	}
}
