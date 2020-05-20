package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.repository.ProdutoRepositoryImpl;

public final class ProdutoServiceImpl {
	
	private ProdutoRepositoryImpl produtoRepository;
	
	private static ProdutoServiceImpl INTANCE = new ProdutoServiceImpl();
	
	public ProdutoServiceImpl() {
		this.produtoRepository = ProdutoRepositoryImpl.getInstance();
	}

	public Produto addProduct(Produto produto) {
		return produtoRepository.save(produto);
	}

	public static ProdutoServiceImpl getInstance() {
		return INTANCE;
	}

}
