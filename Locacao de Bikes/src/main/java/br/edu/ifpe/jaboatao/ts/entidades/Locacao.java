package br.edu.ifpe.jaboatao.ts.entidades;

import java.util.Date;

public class Locacao {

	private Cliente cliente;
	private Bicicleta bicicleta;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valorLocacao;
	
	public Locacao() {}
	public Locacao(Cliente cliente, Bicicleta bicicleta, Date dataLocacao, Date dataRetorno, Double valorLocacao) {
		this.cliente = cliente;
		this.bicicleta = bicicleta;
		this.dataLocacao = dataLocacao;
		this.dataRetorno = dataRetorno;
		this.valorLocacao = valorLocacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(Double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

}