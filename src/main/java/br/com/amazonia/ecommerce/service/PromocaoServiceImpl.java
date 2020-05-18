package br.com.amazonia.ecommerce.service;

import java.util.Map;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.Produto;

public final class PromocaoServiceImpl {

	private static PromocaoServiceImpl promocaoServiceImpl = new PromocaoServiceImpl();
	private Map<String, Double> promocoesAtivas;
	
	private PromocaoServiceImpl() {
		
	}
	
	public PromocaoServiceImpl getInstance() {
		return promocaoServiceImpl;
	}
	
	public Carrinho aplicarCupomPromocional(Carrinho carrinho, String cupom) {
		
		if(!promocoesAtivas.containsKey(cupom)) {
			//TODO inserir exception cupom invalido
			return carrinho;
		}
		
		for(String key : carrinho.getItens().keySet()) {
			ItemCarrinho item = carrinho.getItens().get(key);
			Produto produto = carrinho.getItens().get(key).getProduto();
			if(produto.getCopunsPromocionaisElegiveis().contains(cupom)) {
				item.setPrecoTotal(item.getPrecoTotal()* promocoesAtivas.get(cupom));
			}
		}		
		return carrinho;		
	}
	
	public void addPromocao(String cupom, double desconto) {
		
		if(desconto < 0 && desconto > 1) {
			//TODO inserir exception desconto fora do intervalo de 0 - 1
			return;
		}
		
		promocoesAtivas.put(cupom, desconto);
		
	}
	
}
