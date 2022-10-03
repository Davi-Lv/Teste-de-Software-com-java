package br.edu.ifpe.jaboatao.ts.entidades;

public class Bicicleta {
	private String nome;
	private Integer estoque;
	private Double valor;
//	private String modelo;
	
	public Bicicleta() {}
	
	public Bicicleta(String nome, Integer estoque, Double valor) {
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	} 
}
