package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

public class AssertivasTest {
	
	@DisplayName("assertTrue")
	@Test
	public void teste01() {
		//False e True
		Assertions.assertTrue(true, "Era esperado um True");
		Assertions.assertFalse(false);
	}
	
	@DisplayName("assertEquals")
	@Test
	public void teste02() {
		//Numeros
		//numero igual ao outro
		Assertions.assertEquals(1, 1, "os valores precisam ser iguais");
		//se for diferente
		Assertions.assertNotEquals(1, 2);
		Assertions.assertEquals(1.1, 1.1);
		Assertions.assertEquals(Math.PI, 3.141,0.001);
		//Texto
		//testo igual ao outro
		Assertions.assertEquals("casa", "casa");

		//numero igual ao outro com IgnoreCase
		Assertions.assertTrue("casa".equalsIgnoreCase("Casa"));
		//Objetos
		Cliente cliente01 = new Cliente("Ana");
		Cliente cliente02 = new Cliente("Ana");
		//objeto igual ao outro
		Assertions.assertEquals(cliente01, cliente02);
	}
	
	@DisplayName("assertSame")
	@Test
	public void teste03() {
		//Objetos
		Cliente cliente01 = new Cliente("Ana");
		Cliente cliente02 = new Cliente("Ana");
		Cliente cliente03 = null;		

		Assertions.assertNull(cliente03);
		//Assertions.assertNotNull(cliente03 == null);
		//Assertions.assertNotNull(cliente03);
	}
	
//testando a função de mostrar todos os erros
//	@Test
//	public void teste04() {
//		Assertions.assertTrue(false, "Era esperado um True");
//		Assertions.assertEquals("casa", "Casa");
//		Assertions.assertEquals("casa", "Casa");
//
//		Assertions.assertAll(
//				() -> Assertions.assertTrue(false, "Erro 01: Era esperado um True"),
//				() -> Assertions.assertFalse(true, "Erro 02"),
//				() -> Assertions.assertEquals("casa", "Casa", "Erro 03")
//				);	
//		}
}
