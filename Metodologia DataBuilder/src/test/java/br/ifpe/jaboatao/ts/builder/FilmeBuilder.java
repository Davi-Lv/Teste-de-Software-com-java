package br.ifpe.jaboatao.ts.builder;

import br.ifpe.jaboatao.ts.entidades.Filme;

public class FilmeBuilder {
	private Filme filme;

	private FilmeBuilder() {

	}
	
	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme("Filme 01", 0, 10.0);
		return builder;
	}
	
	public FilmeBuilder comEstoque(int estoque) {
		filme.setEstoque(estoque);
		return this;
	}
	
	public FilmeBuilder semEstoque() {
		filme.setEstoque(null);
		return this;
	}
	
	public Filme agora() {
		return filme;
	}
}
