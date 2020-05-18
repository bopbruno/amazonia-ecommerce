package br.com.amazonia.ecommerce.repository;

import br.com.amazonia.ecommerce.domain.Produto;

public interface ProdutoRepository {

	Produto save(Produto produto);

	Produto getProdutoById(String string);

}