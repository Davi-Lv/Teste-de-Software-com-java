package br.ifpe.jaboatao.ts.entidades;

public class Filme {

	private String titulo;
	private Integer estoque;
	private Double valor;

	public Filme() {
	}

	public Filme(String titulo, Integer estoque, Double valor) {
		this.titulo = titulo;
		this.estoque = estoque;
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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