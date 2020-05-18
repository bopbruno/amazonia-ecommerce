package br.com.amazonia.ecommerce.domain;

import java.math.BigDecimal;

public class DetalheEnvio {

	
	private Endereco enderecoEnvio;
	private BigDecimal custoEnvio;
	
	
	public DetalheEnvio() {
		this.custoEnvio = new BigDecimal(0);
		this.enderecoEnvio = new Endereco();
	}
	
	public BigDecimal getCustoEnvio() {
		return custoEnvio;
	}

	public Endereco getEnderecoEnvio() {
		return enderecoEnvio;
	}
	
}
