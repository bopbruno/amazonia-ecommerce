package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.OrdemCompra;
import br.com.amazonia.ecommerce.repository.OrdemCompraRepositoryImpl;

public class OrdemCompraServiceImpl {
	
	private OrdemCompraRepositoryImpl ordemCompraRepository;
		
	private CarrinhoServiceImpl carrinhoService;
	
	public OrdemCompraServiceImpl() {
		this.carrinhoService = CarrinhoServiceImpl.getInstance();
		this.ordemCompraRepository = OrdemCompraRepositoryImpl.getInstance();
	}

	public int finalizarOrderCompra(OrdemCompra ordemCompra) {
		
		int idOrderCompra =  ordemCompraRepository.addOrdemCompra(ordemCompra).getId();
		carrinhoService.excluirCarrinho(ordemCompra.getCarrinho().getId());
		return idOrderCompra;
	}

}
