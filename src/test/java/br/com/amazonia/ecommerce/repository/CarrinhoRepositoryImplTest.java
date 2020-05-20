package br.com.amazonia.ecommerce.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Carrinho;

public class CarrinhoRepositoryImplTest {
	
	@Test
	public void criarCarrinho_CarrinhoCriadoComSucesso() {
		
		CarrinhoRepositoryImpl carrinhoRepository = CarrinhoRepositoryImpl.getInstance();
		
		Carrinho carrinhoRetorno = carrinhoRepository.criarCarrinho();
		 
		 assertNotNull(carrinhoRetorno);
		
	}
	
	
	@Test
	public void deletarCarrinho_CarrinhoDeletadoComSucesso() {
		
		CarrinhoRepositoryImpl carrinhoRepository = CarrinhoRepositoryImpl.getInstance();
		
		Carrinho carrinhoRetorno = carrinhoRepository.criarCarrinho();
		
		carrinhoRepository.delete(carrinhoRetorno.getId());
		 
		 assertNull(carrinhoRepository.getCarrinho(carrinhoRetorno.getId()));
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void deletarCarrinho_ErroIdNaoEncontrado() {
		CarrinhoRepositoryImpl carrinhoRepository = CarrinhoRepositoryImpl.getInstance();
		
		Carrinho carrinhoRetorno = carrinhoRepository.criarCarrinho();
		 
		carrinhoRepository.delete(carrinhoRetorno.getId()+1);

	}

}
