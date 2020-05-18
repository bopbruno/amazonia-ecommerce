package br.com.amazonia.ecommerce.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.amazonia.ecommerce.domain.Cliente;

public final class ClienteRepositoryImpl implements ClienteRepository {
	
	private static final ClienteRepositoryImpl INSTANCE = new ClienteRepositoryImpl();
	private Map<String, Cliente> listaDeClientes;

	private ClienteRepositoryImpl() {
		listaDeClientes = new HashMap<String, Cliente>();
	}
	
	public static ClienteRepositoryImpl getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Cliente getClienteById(String email) {
		return listaDeClientes.get(email);
	}

	@Override
	public Cliente save(Cliente cliente) {
		listaDeClientes.put(cliente.getEmail(), cliente);
		return listaDeClientes.put(cliente.getEmail(), cliente);
	}

}
