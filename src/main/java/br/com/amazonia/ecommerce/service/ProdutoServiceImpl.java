package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.repository.ProdutoRepository;

public class ProdutoServiceImpl {
	
	ProdutoRepository produtoRepository;
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Produto addProduct(Produto produto) {
		return produtoRepository.save(produto);
	}

}
