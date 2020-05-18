package br.com.amazonia.ecommerce.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.Carrinho;

public final class CarrinhoRepositoryImpl {

	private static final CarrinhoRepositoryImpl INSTANCE = new CarrinhoRepositoryImpl();
	private final Map<Integer, Carrinho> listaDeCarrinhos = new HashMap<>();

	public static CarrinhoRepositoryImpl getInstance() {
		return INSTANCE;
	}

	public Carrinho getCarrinho(int idCarrinho) {
		return listaDeCarrinhos.get(idCarrinho);
	}

	public Carrinho criarCarrinho(Carrinho carrinho) {
		if (listaDeCarrinhos.keySet().contains(carrinho.getId())) {
			throw new IllegalArgumentException("Can not create a cart. A cart with the give id aldrady exist "+ carrinho.getId());
		}

		return listaDeCarrinhos.put(carrinho.getId(), carrinho);
	}

	public void delete(int idCarrinho) {
	    if(!listaDeCarrinhos.keySet().contains(idCarrinho)) {
	        throw new IllegalArgumentException(String.format("Can not delete cart. The cart with the give id (%) does not does not exist",idCarrinho));
	      }

	    listaDeCarrinhos.remove(idCarrinho);
	    }

}
