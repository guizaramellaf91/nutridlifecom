package nutridlifecom;

public class Alimento {
	
	private String nome;
	private String grupoAlimentar;
	private Integer caloria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrupoAlimentar() {
		return grupoAlimentar;
	}
	public void setGrupoAlimentar(String grupoAlimentar) {
		this.grupoAlimentar = grupoAlimentar;
	}
	public Integer getCaloria() {
		return caloria;
	}
	public void setCaloria(Integer caloria) {
		this.caloria = caloria;
	}
}