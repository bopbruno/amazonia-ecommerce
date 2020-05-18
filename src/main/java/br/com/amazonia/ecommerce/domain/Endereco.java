package br.com.amazonia.ecommerce.domain;

public class Endereco {

	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "cep";
	}	
	
}