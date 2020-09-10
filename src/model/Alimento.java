package model;

public class Alimento {
	
	private String nome;
	private Integer grupo;
	private Integer caloria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	public Integer getCaloria() {
		return caloria;
	}
	public void setCaloria(Integer caloria) {
		this.caloria = caloria;
	}
}