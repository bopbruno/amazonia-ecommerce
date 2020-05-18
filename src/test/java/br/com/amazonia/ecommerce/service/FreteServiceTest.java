package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.correios.CResultado;

public class FreteServiceTest {

	
	@Test
	public void calcularFrete_FreteCalculadoComSucesso() {
		
		FreteServiceImpl freteServiceImpl = FreteServiceImpl.getInstance();
		
		CResultado resultado = freteServiceImpl.calcularFrete("01213010", "0.3", new BigDecimal(30), new BigDecimal(2), new BigDecimal(15), new BigDecimal(0), new BigDecimal(0), "04510");
		//(String sCepDestino, String nVlPeso, BigDecimal nVlComprimento, BigDecimal nVlAltura, BigDecimal nVlLargura, BigDecimal nVlDiametro, BigDecimal nVlValorDeclarado, String nCdServico)
		
		assertEquals(resultado.getServicos()[0].getErro(), "0");
	}
}
