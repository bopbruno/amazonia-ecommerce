package br.com.amazonia.ecommerce.service;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.Produto;
import br.com.amazonia.ecommerce.exception.CupomInvalidoException;

public final class PromocaoServiceImpl {

	private static PromocaoServiceImpl promocaoServiceImpl = new PromocaoServiceImpl();
	private Map<String, Double> promocoesAtivas;
	
	private PromocaoServiceImpl() {
		promocoesAtivas = new HashMap<>();
	}
	
	public static PromocaoServiceImpl getInstance() {
		return promocaoServiceImpl;
	}
	
	public Carrinho aplicarCupomPromocional(Carrinho carrinho, String cupom) throws CupomInvalidoException {
		
		if(!promocoesAtivas.containsKey(cupom)) {
			throw new CupomInvalidoException();
		}
		
		for(String key : carrinho.getItens().keySet()) {
			ItemCarrinho item = carrinho.getItens().get(key);
			Produto produto = carrinho.getItens().get(key).getProduto();
			if(produto.getCopunsPromocionaisElegiveis().contains(cupom)) {
				item.setPrecoTotal(item.getPrecoTotal()* (1-promocoesAtivas.get(cupom)) );
			}
		}
		carrinho.atualizarValorTotal();
		return carrinho;		
	}
	
	public void addPromocao(String cupom, double desconto) {
		
		if(desconto < 0 && desconto > 1) {
			throw new IllegalArgumentException("desconto fora do intervalo de ( 0 ) - ( 1 )");
		}
		
		promocoesAtivas.put(cupom, desconto);
		
	}
	
}
