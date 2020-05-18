package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.repository.CarrinhoRepositoryImpl;

public final class CarrinhoServiceImpl {
	
	private CarrinhoRepositoryImpl carrinhoRepositoryImpl;
	
	private static CarrinhoServiceImpl carrinhoService = new CarrinhoServiceImpl();

	private CarrinhoServiceImpl() {
		this.carrinhoRepositoryImpl = CarrinhoRepositoryImpl.getInstance();
	}

	public Carrinho criarCarrinho(Carrinho carrinho) {
		return carrinhoRepositoryImpl.criarCarrinho(carrinho);
	}

	public static CarrinhoServiceImpl getInstance() {
		return carrinhoService;
	}

	public void excluirCarrinho(int idCarrinho) {
		carrinhoRepositoryImpl.delete(idCarrinho);
	}

}
