package br.com.amazonia.ecommerce.domain;

public class OrdemCompra {

	private int id;
	private Cliente cliente;
	private Carrinho carrinho;
	private DetalheEnvio detalheEnvio;
	
	public OrdemCompra(Cliente cliente,Carrinho carrinho,DetalheEnvio detalheEnvio) {
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
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public DetalheEnvio getDetalheEnvio() {
		return detalheEnvio;
	}
	public void setDetalheEnvio(DetalheEnvio detalheEnvio) {
		this.detalheEnvio = detalheEnvio;
	}

}
