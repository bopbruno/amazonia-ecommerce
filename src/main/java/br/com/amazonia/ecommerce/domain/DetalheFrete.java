package br.com.amazonia.ecommerce.domain;

public class DetalheFrete {

	private String cepEnvio;
	private double custoEnvio;
	private int prazoEntrega;
	
	public DetalheFrete(String cepEnvio,double custoEnvio,int prazoEntrega) {
		this.custoEnvio = custoEnvio;
		this.cepEnvio = cepEnvio;
		this.prazoEntrega = prazoEntrega;
	}
	
	public double getCustoEnvio() {
		return custoEnvio;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public String getCepEnvio() {
		return cepEnvio;
	}
	
}
