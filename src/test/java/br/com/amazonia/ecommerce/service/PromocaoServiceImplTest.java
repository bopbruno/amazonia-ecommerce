package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.exception.CupomInvalidoException;

public class PromocaoServiceImplTest {

	@Test
	public void aplicarCupomPromocionalComSucesso() throws CupomInvalidoException {
		
		PromocaoServiceImpl promocaoService = PromocaoServiceImpl.getInstance();
		
		String cupom = "desconto10";
		
		Carrinho carrinho = new Carrinho(1);
		
		Produto produto = new Produto("1", 10, "celular", false);
		
		produto.addCopunsPromocionais(cupom);
		
		ItemCarrinho item = new ItemCarrinho(produto);
		
		carrinho.addItem(item);
		
		promocaoService.addPromocao(cupom, 0.1);
		
		promocaoService.aplicarCupomPromocional(carrinho, cupom);
		
		assertEquals(9, carrinho.getItens().get("1").getPrecoTotal(), 0.001);
		
		
	}
}
