package br.com.amazonia.ecommerce.service;

import br.com.amazonia.ecommerce.domain.Cliente;
import br.com.amazonia.ecommerce.repository.ClienteRepositoryImpl;

public final class ClienteServiceImpl {
	
	private static ClienteRepositoryImpl clienteRepository;
	private static ClienteServiceImpl clienteService = new ClienteServiceImpl();
	
	private ClienteServiceImpl() {
		ClienteServiceImpl.clienteRepository = ClienteRepositoryImpl.getInstance();
	}

	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public static ClienteServiceImpl getInstance() {
		return clienteService;
	}

}