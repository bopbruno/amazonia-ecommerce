package br.com.amazonia.ecommerce.repository;

import br.com.amazonia.ecommerce.domain.Cliente;

public interface ClienteRepository {

	Cliente getClienteById(String email);

	Cliente save(Cliente cliente);
}