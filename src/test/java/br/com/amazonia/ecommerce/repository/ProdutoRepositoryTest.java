package br.com.amazonia.ecommerce.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Produto;

public class ProdutoRepositoryTest {
	
	ProdutoRepository produtoRepository = ProdutoRepositoryImpl.getInstance();
	
	@Test
	public void addProduto_ProdutoAddComSucesso() {
		Produto produto = new Produto("1", 10, "Celular", false);
		
		produtoRepository.save(produto);
		
		
		assertEquals(produtoRepository.getProdutoById(produto.getEAN()), produto);
	}

}
