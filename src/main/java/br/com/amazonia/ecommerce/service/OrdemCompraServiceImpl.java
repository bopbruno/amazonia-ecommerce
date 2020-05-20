package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.ItemCarrinho;
import br.com.amazonia.ecommerce.domain.OrdemCompra;
import br.com.amazonia.ecommerce.repository.OrdemCompraRepositoryImpl;

public final class OrdemCompraServiceImpl {
	
	private static OrdemCompraServiceImpl ordemCompraService = new OrdemCompraServiceImpl();
	
	private OrdemCompraRepositoryImpl ordemCompraRepository;
		
	private CarrinhoServiceImpl carrinhoService;
	
	private CalculadoraImpostoServiceImpl calculadoraImpostoServiceImpl;
	
	private OrdemCompraServiceImpl() {
		this.carrinhoService = CarrinhoServiceImpl.getInstance();
		this.ordemCompraRepository = OrdemCompraRepositoryImpl.getInstance();
		this.calculadoraImpostoServiceImpl = CalculadoraImpostoServiceImpl.getInstance();
	}

	public static OrdemCompraServiceImpl getOrdemCompraService() {
		return ordemCompraService;
	}
	
	public int finalizarOrderCompra(OrdemCompra ordemCompra) {
		
		double totalImposto = calcularImposto(ordemCompra);
		
		ordemCompra.setTotalImposto(totalImposto);
		
		int idOrderCompra =  ordemCompraRepository.addOrdemCompra(ordemCompra).getId();
		
		carrinhoService.excluirCarrinho(ordemCompra.getCarrinho().getId());
		
		return idOrderCompra;
	}

	private double calcularImposto(OrdemCompra ordemCompra) {
		double totalImposto = 0.0;
		
		for( String key :  ordemCompra.getCarrinho().getItens().keySet()) {
			 ItemCarrinho item =  ordemCompra.getCarrinho().getItens().get(key);
			 
			 double impostoUnidade = calculadoraImpostoServiceImpl.calcularImposto(item.getProduto());
			 
			 totalImposto += impostoUnidade * item.getQuantidade();
			 
		}
		return totalImposto;
	}

}
