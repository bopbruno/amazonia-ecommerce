package br.com.amazonia.ecommerce.repository;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.amazonia.ecommerce.domain.Carrinho;
import br.com.amazonia.ecommerce.domain.Cliente;
import br.com.amazonia.ecommerce.domain.DetalheFrete;
import br.com.amazonia.ecommerce.domain.OrdemCompra;

public class OrdemCompraRepositoryImplTest {
	
	@Test
	public void criarOrdemCompra_OrdermCriadaComSucesso() {
		
		OrdemCompraRepositoryImpl OrdemCompraRepository = OrdemCompraRepositoryImpl.getInstance();
		
		Cliente cliente = Mockito.mock(Cliente.class);
		Carrinho carrinho = Mockito.mock(Carrinho.class);
		DetalheFrete detalheFrete = Mockito.mock(DetalheFrete.class);
		
		OrdemCompra ordemCompra = new OrdemCompra(cliente, carrinho, detalheFrete);
		
		OrdemCompraRepository.addOrdemCompra(ordemCompra);
		
		assertNotEquals(0, ordemCompra.getId());
		
	}

}
