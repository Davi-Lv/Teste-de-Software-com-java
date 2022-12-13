package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocacaoException {
		// Verificar se o filme � nulo.
		if (filmes == null) {
			throw new LocacaoException("Filme nulo.");
		}
		// Verificar se estoque est� vazio.
		for (Filme filme : filmes) {
			if (filme.getEstoque() == 0) {
				throw new LocacaoException("Filme sem estoque.");
			}
		}

		// Verificar se o usu�rio � nulo.
		if (usuario == null) {
			throw new LocacaoException("Usu�rio nulo.");
		}

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		double valorTotal = 0;
		for (Filme filme : filmes) {
			valorTotal += filme.getValor();
		}
		locacao.setValorLocacao(valorTotal);

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

}