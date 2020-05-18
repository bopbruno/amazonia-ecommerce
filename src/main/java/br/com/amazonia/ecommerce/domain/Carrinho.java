package br.com.amazonia.ecommerce.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Carrinho {

	private int id;
	private Map<String, ItemCarrinho> itens;
	private double valorTotalCarrinho;

	public Carrinho(int id) {
		this.id = id;
		itens = new HashMap<>();
		valorTotalCarrinho = 0;
	}

	public void addItem(ItemCarrinho item) {
		String productId = item.getProduto().getId();

		if (itens.containsKey(productId)) {
			ItemCarrinho existingCartItem = itens.get(productId);
			existingCartItem.setQuantidade(existingCartItem.getQuantidade() + item.getQuantidade());
			itens.put(productId, existingCartItem);
		} else {
			itens.put(productId, item);
		}
		atualizarValorTotal();

	}

	private void atualizarValorTotal() {
		valorTotalCarrinho= 0;
	    for(ItemCarrinho item : itens.values()){
	    	valorTotalCarrinho = valorTotalCarrinho + item.getPrecoTotal();
	    }
	  }

	public Map<String, ItemCarrinho> getItens() {
		return itens;
	}

	public int getId() {
		return id;
	}

}
