package br.com.amazonia.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.amazonia.ecommerce.domain.Imposto;
import br.com.amazonia.ecommerce.domain.Produto;

public final class CalculadoraImpostoServiceImpl {
	
	private static CalculadoraImpostoServiceImpl calculadoraImpostoServiceImpl = new CalculadoraImpostoServiceImpl();
	private List<Imposto> impostosCadastrados;	
	
	private CalculadoraImpostoServiceImpl() {
		impostosCadastrados = new ArrayList<Imposto>();
	}
	
	public static CalculadoraImpostoServiceImpl getInstance() {
		return calculadoraImpostoServiceImpl;
	}
	
	public double calcularImposto(Produto produto) {
		
		double impostoTotal = 0.0;
		
		for(Imposto imposto:impostosCadastrados) {
			if(imposto.getTipoProdutoEnquadrado().contains(produto.getTipo())) {
				impostoTotal = impostoTotal + (imposto.getPorcentagemImporto() *produto.getPrecoUnitario());
			}	
		}
		
		produto.setValorImposto(impostoTotal);
		
		return impostoTotal;
	}
	
	public void addImposto(Imposto imposto) {
		if(!impostosCadastrados.contains(imposto)) {
			impostosCadastrados.add(imposto);
		}
	}
}