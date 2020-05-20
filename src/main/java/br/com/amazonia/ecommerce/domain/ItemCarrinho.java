package br.com.amazonia.ecommerce.domain;

public class ItemCarrinho {
	
	private Produto produto;
	private int quantidade;
	private double precoTotal;
	
	public ItemCarrinho(Produto produto) {
		this.produto = produto;
		this.quantidade = 1;
		this.precoTotal = produto.getPrecoUnitario();
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public double atualizarPrecoTotal() {
		
		return 0;
	}
	
}
