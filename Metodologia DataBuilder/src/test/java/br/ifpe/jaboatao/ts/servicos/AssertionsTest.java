package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertionsTest {

	@Test
	public void assertTrue(){
		Assertions.assertTrue(true, "");
		Assertions.assertFalse(false);
		
	}
	@Test
	public void assertEquals() {
		//Inteiros
		Assertions.assertEquals(1, 1,"Era esperado o valor 1, mas veio outro valor.");
		Assertions.assertNotEquals(1, 2);
		//Decimais
		Assertions.assertEquals(1.1, 1.1);
		Assertions.assertEquals(Math.PI, 3.141,0.001);
		//String
		Assertions.assertEquals("casa".toLowerCase(), "Casa".toLowerCase());
		//Objetos
		Usuario u1 = new Usuario("Usuário 01");
		Usuario u2 = new Usuario("Usuário 01");
		
	    Assertions.assertEquals(u1, u2);
	}
	
	@Test
	public void assertSame() {
		Usuario u1 = new Usuario("Usuário 01");
		Usuario u2 = new Usuario("Usuário 01");	
		Usuario u3 = u2;
		Assertions.assertSame(u2, u3);
		Assertions.assertNotSame(u1, u3);
	}
}
