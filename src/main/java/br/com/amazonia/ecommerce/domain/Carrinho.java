package br.com.amazonia.ecommerce.domain;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.interfaces.Enviavel;

public class Carrinho implements Enviavel{

	private int id;
	private Map<String, ItemCarrinho> itens;
	private double valorTotalCarrinho;
	private Encomenda encomenda;

	public Carrinho() {
		itens = new HashMap<>();
		valorTotalCarrinho = 0;
	}
	
	public Carrinho(int id) {
		this.id = id;
		itens = new HashMap<>();
		valorTotalCarrinho = 0;
	}

	public void addItem(ItemCarrinho item) {
		String idProduto = item.getProduto().getEAN();

		if (itens.containsKey(idProduto)) {
			ItemCarrinho existingCartItem = itens.get(idProduto);
			existingCartItem.setQuantidade(existingCartItem.getQuantidade() + item.getQuantidade());
			itens.put(idProduto, existingCartItem);
		} else {
			itens.put(idProduto, item);
		}
		atualizarValorTotal();

	}

	public void atualizarValorTotal() {
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

	@Override
	public Encomenda getEncomendaASerEnviada() {
		encomenda = new Encomenda( 0.3, 30, 2, 15, 0.2, 1, 0.00);
		return encomenda;
	}

}
