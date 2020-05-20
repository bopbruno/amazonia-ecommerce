package br.com.amazonia.ecommerce.domain;

public class OrdemCompra {

	private int id;
	private Cliente cliente;
	private Carrinho carrinho;
	private DetalheFrete detalheEnvio;
	private double totalImposto;

	public OrdemCompra(Cliente cliente,Carrinho carrinho,DetalheFrete detalheEnvio) {
		this.cliente = cliente;
		this.carrinho = carrinho;
		this.detalheEnvio = detalheEnvio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}

	public void setTotalImposto(double totalImposto) {
		this.totalImposto = totalImposto;
	}
	
	public DetalheFrete getDetalheEnvio() {
		return detalheEnvio;
	}

}
