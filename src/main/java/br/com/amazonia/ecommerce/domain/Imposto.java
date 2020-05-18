package br.com.amazonia.ecommerce.domain;

import java.util.List;

import br.com.amazonia.ecommerce.enuns.TipoProdutoEnum;

public class Imposto {
	
	private List<TipoProdutoEnum> tipoProdutoEnquadrado;
	private double porcentagemImporto;
	
	public Imposto(List<TipoProdutoEnum> tipoProdutoEnquadrado,Double porcentagemImporto) {
		this.tipoProdutoEnquadrado = tipoProdutoEnquadrado; 
		this.porcentagemImporto = porcentagemImporto;
	}

	public List<TipoProdutoEnum> getTipoProdutoEnquadrado() {
		return tipoProdutoEnquadrado;
	}

	public double getPorcentagemImporto() {
		return porcentagemImporto;
	}

}
