package br.edu.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

//mostrar o texto no junit
@DisplayName("Testando assertivas")
public class AssertivasTest {
	@Test
	// mostrar o texto no junit
	@DisplayName("teste assertTrue e assertFalse")
	public void teste1() {
		// testa se é verdadeiro
		Assertions.assertTrue(true);
		// testa se é falso
		Assertions.assertFalse(false);
	}

	@Test
	// mostrar o texto no junit
	@DisplayName("teste assertEquals")
	public void teste2() {
		// assertEqual para testar se o valor espectativa é igual ao atual
		// funciona com texto e numeros
		// colocar um texto do lado é para caso der erro e apareça a mensagem
		Assertions.assertEquals(1, 1, "o valor deveria igual a 1");
		Assertions.assertEquals("teste", "teste");

		Cliente cliente1 = new Cliente("cliente 1");
		Cliente cliente2 = new Cliente("cliente 1");

		Assertions.assertEquals(cliente1, cliente2);

		// com o ignoreCase
		Assertions.assertTrue("Teste".equalsIgnoreCase("teste"));

	}

	@Test
	// mostrar o texto no junit
	@DisplayName("teste assertSame")
	public void teste4() {
		Cliente cliente1 = new Cliente("cliente 1");
		Cliente cliente2 = cliente1;
		// apenas com a mesma instancia
		Assertions.assertSame(cliente1, cliente2);

	}

	@Test
	// mostrar o texto no junit
	@DisplayName("teste assertNull")
	public void teste5() {
		Cliente cliente1 = null;
		Cliente cliente2 = new Cliente("cliente 1");

		// caso seja null entrega verdadeiro
		Assertions.assertNull(cliente1);
		// se não for nulo entrega verdadeiro
		// o "not" é a negação, serve para todos
		Assertions.assertNotNull(cliente2);
	}

	@Test
	// mostrar o texto no junit
	@DisplayName("teste assertAll")
	public void teste6() {
		//para verificas todos os erros listados
		Assertions.assertAll(
				() -> Assertions.assertEquals("teste", "teste", "é esperado teste"),
				() -> Assertions.assertEquals(1, 1, "é esperado um valor igual a 1"),
				() -> Assertions.assertTrue(true, "é esperado true")
				);
	}
}
