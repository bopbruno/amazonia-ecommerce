package br.com.amazonia.ecommerce.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.Produto;

public final class ProdutoRepositoryImpl implements ProdutoRepository {
	
	private static final ProdutoRepository INSTANCE = new ProdutoRepositoryImpl();
	private static final Map<String, Produto> listaDeProdutos = new HashMap<>();
	
	private ProdutoRepositoryImpl() {
		
	}

	public static ProdutoRepository getInstance() {
		return INSTANCE;
	}

	@Override
	public Produto save(Produto produto) {
		return listaDeProdutos.put(produto.getId(), produto);
	}

	@Override
	public Produto getProdutoById(String EAN) {
		return listaDeProdutos.get(EAN);
	}

}
