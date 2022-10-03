package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoServiceTest {
	@Test
	public void teste01() {
		//System.out.println("Funcionando.");
		//Cen�rio
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bike = new Bicicleta("Bike 01", 1, 40.0);
		
		
		//A��o
		Locacao locacao = service.alugarBicicleta(cliente, bike);
		
		//Verifica��o / valida��o
//		Assertions.assertEquals( 40.0, locacao.getValorLocacao() );
//		Assertions.assertTrue( ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()) );
//		Assertions.assertTrue( ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), novaDataComDiferencaDeDias(3)) );
//		
//		Assertions.assertEquals( "Cliente 01", locacao.getCliente().getNome() );
//		Assertions.assertEquals( 1, locacao.getBicicleta().getEstoque() );
		
//	 	testando todos os erros (caso exista)
		Assertions.assertAll(
				() -> Assertions.assertEquals( 50.0, locacao.getValorLocacao() ,"erro 37"),
				() -> Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()) ,"erro 38"),
				() -> Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), novaDataComDiferencaDeDias(3)) ,"erro 39"),
				
				() -> Assertions.assertEquals( "Cliente 02", locacao.getCliente().getNome() ,"erro 41"),
				() -> Assertions.assertEquals( 2, locacao.getBicicleta().getEstoque() ,"erro 42")
				);		
	}
}
