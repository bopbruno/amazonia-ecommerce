package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Cliente;

public class ClienteServiceTest {

	@Test
	public void cadastrarCliente_ClienteCadastradoComSucesso() {
		
		Cliente cliente = new Cliente("bruno@mail.com");
		ClienteServiceImpl clienteService = ClienteServiceImpl.getInstance();
				
		Cliente clienteEsperado = clienteService.addCliente(cliente);
		
		assertEquals(cliente, clienteEsperado);
		
	}
	
}
