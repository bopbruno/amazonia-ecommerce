package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.repository.ProdutoRepositoryImpl;

public class ProdutoServiceImplTest {

	
	@Test
	public void addProduto_ProdutoAddComSucesso() {
		
		ProdutoServiceImpl produtoServiceImpl = ProdutoServiceImpl.getInstance();
		
		ProdutoRepositoryImpl produtoRepositoryImpl = ProdutoRepositoryImpl.getInstance();
		
		Produto produto =  new Produto(null, 0, null, false);
		
		produtoRepositoryImpl.save(produto);
		
		Produto resultado = produtoServiceImpl.addProduct(produto);
		
		assertEquals(resultado, produto);
		
	}
}
