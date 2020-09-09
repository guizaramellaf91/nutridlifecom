package nutridlifecom;

import java.time.LocalDate;

public class FichaNutri {
	
	private Cliente cliente;
	private LocalDate dataCadastro;
	private String peso;
	private Double percentualGordura;
	private String sensacaoFisica;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
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
}