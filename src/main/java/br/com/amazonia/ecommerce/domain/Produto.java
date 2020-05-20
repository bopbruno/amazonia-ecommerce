package br.com.amazonia.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.amazonia.ecommerce.enuns.TipoProdutoEnum;

public class Produto {
	
	private String EAN; 
	private String nome;
	private double precoUnitario;
	private List<String> copunsPromocionaisElegiveis;
	private boolean isEntregaDigital;
	private double valorImposto;
	private TipoProdutoEnum tipo;
	
	public Produto(String EAN, double precoUnitario, String nome, boolean isEntregaDigital) {
		this.EAN = EAN;
		this.precoUnitario = precoUnitario;
		this.nome = nome;
		this.setEntregaDigital(isEntregaDigital);
		copunsPromocionaisElegiveis = new ArrayList<>();
	}

	public String getEAN() {
		return EAN;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public String getNome() {
		return nome;
	}
	
	public void addCopunsPromocionais(String cupom) {		
		copunsPromocionaisElegiveis.add(cupom);
	}

	public List<String> getCopunsPromocionaisElegiveis() {
		return copunsPromocionaisElegiveis;
	}

	public void setCopunsPromocionaisElegiveis(List<String> copunsPromocionaisElegiveis) {
		this.copunsPromocionaisElegiveis = copunsPromocionaisElegiveis;
	}

	public boolean isEntregaDigital() {
		return isEntregaDigital;
	}

	public void setEntregaDigital(boolean isEntregaDigital) {
		this.isEntregaDigital = isEntregaDigital;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public TipoProdutoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoProdutoEnum tipo) {
		this.tipo = tipo;
	}

}
