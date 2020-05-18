package br.com.amazonia.ecommerce.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amazonia.ecommerce.domain.Cliente;

public class ClienteRepositoryTest {

	@Test
	public void inserirCliente_ClienteInseridoComSucesso() {
		//arrange
		ClienteRepository clienteRepository = ClienteRepositoryImpl.getInstance();
		
		Cliente cliente = new Cliente("bruno@mail.com");
		
		//act
		clienteRepository.save(cliente);
		
		//assert
		assertEquals(cliente, clienteRepository.getClienteById(cliente.getEmail()));
		
	}
}
