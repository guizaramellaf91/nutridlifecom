package nutridlifecom;

import java.time.LocalDateTime;

public class FichaNutri {
	
	private Cliente cliente;
	private LocalDateTime dataCadastro;
	private String peso;
	private Double percentualGordura;
	private String sensacaoFisica;
	private String restricaoAlimentar;
	private Double metaCalorica;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public Double getPercentualGordura() {
		return percentualGordura;
	}
	public void setPercentualGordura(Double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}
	public String getSensacaoFisica() {
		return sensacaoFisica;
	}
	public void setSensacaoFisica(String sensacaoFisica) {
		this.sensacaoFisica = sensacaoFisica;
	}
	public String getRestricaoAlimentar() {
		return restricaoAlimentar;
	}
	public void setRestricaoAlimentar(String restricaoAlimentar) {
		this.restricaoAlimentar = restricaoAlimentar;
	}
	public Double getMetaCalorica() {
		return metaCalorica;
	}
	public void setMetaCalorica(Double metaCalorica) {
		this.metaCalorica = metaCalorica;
	}
}