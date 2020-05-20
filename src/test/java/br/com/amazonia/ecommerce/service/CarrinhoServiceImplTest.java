package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Carrinho;

public class CarrinhoServiceImplTest {
	
	@Test
	public void criarCarrinho_CarrinhoCriadoComSucesso() {
		CarrinhoServiceImpl carrinhoServiceImpl = CarrinhoServiceImpl.getInstance();
		
		Carrinho carrinho = carrinhoServiceImpl.criarCarrinho();
		
		assertNotNull(carrinho);
		
	}

}
