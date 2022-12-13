package br.ifpe.jaboatao.ts.servicos;

import static br.ifpe.jaboatao.ts.builder.UsuarioBuilder.umUsuario;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.ifpe.jaboatao.ts.builder.FilmeBuilder;
import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class LocacaoServiceTest {
	// static int cont = 0;
	LocacaoService service;

	@BeforeEach
	public void antes() {
		service = new LocacaoService();
		// System.out.println("antes");
		// cont++;
		// System.out.println(cont);
	}

	@AfterEach
	public void depois() {
		// System.out.println("depois");
	}

	@BeforeAll
	public static void antesDeTudo() {
		// System.out.println("antesDeTudo");
	}

	@AfterAll
	public static void depoisDeTudo() {
		// System.out.println("depoisDeTudo");
	}

	@Test
	@DisplayName("Exce��o - Estoque vazio. Modo assertionThrow()")
	@Order(1)
	public void filmeSemEstoque() {
		// System.out.println("filmeSemEstoque()");
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		Usuario usuario = umUsuario().agora();
//		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 10.0));
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comEstoque(0).agora());

		// A��o
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
		}, "Era esperado uma exce��o, mas n�o ocorreu.");

		// Valida��o
		Assertions.assertEquals("Filme sem estoque.", e.getMessage());
	}

	@Test
	@DisplayName("Exce��o - Estoque vazio. Modo Tradicional")
	@Order(2)
	public void filmeSemEstoque02() {
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comEstoque(0).agora());

		// A��o
		try {
			Locacao locacao = service.alugarFilme(usuario, filmes);
			Assertions.fail("Deveria ter ocorrido uma exce��o.");
		} catch (LocacaoException e) {
			// Valida��o.
			Assertions.assertEquals("Filme sem estoque.", e.getMessage());
		}

	}

	@Test
	@DisplayName("Exce��o - Usuario nulo. Modo assertionThrow()")
	public void usuarioNulo() {
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		// Usuario usuario = new Usuario("Usuario 01");
//		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 10, 10.0));
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comEstoque(10).agora());

		// A��o
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(null, filmes);
		}, "Era esperado uma exce��o, mas n�o ocorreu.");

		// Valida��o
		Assertions.assertEquals("Usu�rio nulo.", e.getMessage());
	}

	@Test
	@DisplayName("Exce��o - Estoque vazio. Modo Tradicional")
	public void usuarioNulo02() {

		// Cen�rio
		// LocacaoService service = new LocacaoService();
		// Usuario usuario = new Usuario("Usuario 01");
//		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 10, 10.0));
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comEstoque(10).agora());

		// A��o
		try {
			Locacao locacao = service.alugarFilme(null, filmes);
			Assertions.fail("Deveria ter ocorrido uma exce��o.");
		} catch (LocacaoException e) {
			// Valida��o.
			Assertions.assertEquals("Usu�rio nulo.", e.getMessage());
		}

	}

	@Test
	@DisplayName("LocacaoException - Filme Nulo - Modo assertThrow()  ")
	public void filmeNulo() {
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
		// Filme

		// Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, null);

		});

		// Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}

	@Test
	@DisplayName("LocacaoException - Filme Nulo - Modo Tradicional")
	public void filmeNulo2() {
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");

		// A��o
		try {
			Locacao locacao = service.alugarFilme(usuario, null);
			Assertions.fail("Deveria ter ococrrido um exce��o.");
		} catch (LocacaoException e) {
			// Verificacao
			Assertions.assertEquals("Filme nulo.", e.getMessage());
		}

	}

	@Test
	@DisplayName("Valor loca��o - 3 filmes")
	@Disabled
	@Order(3)
	public void valorLocacao() throws LocacaoException {
		// Cen�rio
		// LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
//		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 10, 15.00), new Filme("Filme 02", 2, 15.00),
//				new Filme("Filme 03", 2, 15.00));
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comEstoque(10).agora(), FilmeBuilder.umFilme().comEstoque(2).agora(),
				FilmeBuilder.umFilme().comEstoque(2).agora());
		
		
		// A��o
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verificacao
		Assertions.assertEquals(45.00, locacao.getValorLocacao());
	}
}
