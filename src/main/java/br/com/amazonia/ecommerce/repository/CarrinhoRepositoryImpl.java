package br.com.amazonia.ecommerce.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.Carrinho;

public final class CarrinhoRepositoryImpl {

	private static final CarrinhoRepositoryImpl INSTANCE = new CarrinhoRepositoryImpl();
	private final Map<Integer, Carrinho> listaDeCarrinhos = new HashMap<>();
	private int contadorIdCarrinho = 0;

	public static CarrinhoRepositoryImpl getInstance() {
		return INSTANCE;
	}

	public Carrinho getCarrinho(int idCarrinho) {
		return listaDeCarrinhos.get(idCarrinho);
	}

	public Carrinho criarCarrinho() {
		
		contadorIdCarrinho++;

		Carrinho carrinho = new Carrinho(contadorIdCarrinho);
		
		listaDeCarrinhos.put(contadorIdCarrinho, carrinho);
		
		return carrinho;
	}

	public void delete(int idCarrinho) {
	    if(!listaDeCarrinhos.keySet().contains(idCarrinho)) {
	        throw new IllegalArgumentException("Não foi possivel deletar o carrinho. Carrinho com o id "+idCarrinho+" não existe.");
	      }

	    listaDeCarrinhos.remove(idCarrinho);
	    }

}
