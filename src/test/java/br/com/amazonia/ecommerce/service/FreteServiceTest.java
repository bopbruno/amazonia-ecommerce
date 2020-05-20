package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.amazonia.ecommerce.domain.DetalheFrete;
import br.com.amazonia.ecommerce.domain.Encomenda;
import br.com.amazonia.ecommerce.interfaces.Enviavel;

public class FreteServiceTest {

	
	@Test
	public void calcularFrete_FreteCalculadoComSucesso() throws Exception {
		
		FreteServiceImpl freteServiceImpl = FreteServiceImpl.getInstance();
		
		Enviavel enviavel = Mockito.mock(Enviavel.class);
		
		Encomenda encomenda = new Encomenda(0.3, 30, 2, 15, 0.2, 1, 0.00);
		
		Mockito.when(enviavel.getEncomendaASerEnviada()).thenReturn(encomenda);
		
		String cdAvisoRecebimento = "N";
		String cdMaoPropria = "N";
	    String cdServico="04510";
	    String cepDestino = "90619900";
		
		DetalheFrete resultado = freteServiceImpl.calcularFrete(cdAvisoRecebimento, cdMaoPropria, cdServico, cepDestino, enviavel);
		
		assertEquals(resultado.getCustoEnvio(),24.8 , 0.001);
		assertEquals(resultado.getCepEnvio(),cepDestino);
		assertEquals(resultado.getPrazoEntrega(),9);
	}
}