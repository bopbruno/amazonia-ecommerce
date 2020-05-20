package br.com.amazonia.ecommerce.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.OrdemCompra;

public final class OrdemCompraRepositoryImpl {

	private static OrdemCompraRepositoryImpl ordemCompraRepositoryImpl= new OrdemCompraRepositoryImpl();
	private Map<Integer, OrdemCompra> listaDeOrdens = new HashMap<>();
	private int proximoIdOrdemCompra;
	
	OrdemCompraRepositoryImpl(){
	}
	
	public static OrdemCompraRepositoryImpl getInstance() {
		return ordemCompraRepositoryImpl;
	}

	public OrdemCompra getListaDeOrdens(int idOrdemCompra) {
		return listaDeOrdens.get(idOrdemCompra);
	}

	public OrdemCompra addOrdemCompra(OrdemCompra ordemCompra) {
		ordemCompra.setId(gerarProximoIdOrdemCompra());
		listaDeOrdens.put(ordemCompra.getId(), ordemCompra);
		return ordemCompra;
	}

	private synchronized int gerarProximoIdOrdemCompra() {
		return ++proximoIdOrdemCompra;
	}
}
