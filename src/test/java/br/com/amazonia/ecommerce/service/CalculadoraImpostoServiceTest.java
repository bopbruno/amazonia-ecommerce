package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Imposto;
import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.enuns.TipoProdutoEnum;

public class CalculadoraImpostoServiceTest {

	@Test
	public void calculaImposto_ImpostoCalculadoComSucesso() {
		
		CalculadoraImpostoServiceImpl calculadoraImpostoService = CalculadoraImpostoServiceImpl.getInstance();
		List<TipoProdutoEnum> listTipoProd= new ArrayList<>();
		listTipoProd.add(TipoProdutoEnum.LIVRO);
		
		Imposto imposto = new Imposto(listTipoProd, new Double(0.1));
		Produto produto = new Produto("1", 10, "ps4", false);
		
		produto.setTipo(TipoProdutoEnum.LIVRO);
		
		calculadoraImpostoService.addImposto(imposto);
		
		double impostoTotal = calculadoraImpostoService.calcularImposto(produto);
				
		assertEquals(impostoTotal, 1, 0.001);
		
	}
	
}
