package dev.elton.library.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.elton.library.system.entities.Cliente;
import dev.elton.library.system.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	// CRUD p/ Manter cliente

	// encontrando/listando todos os clientes

	@GetMapping("/clientes")
	public List<Cliente> findAll() {
		return clienteRepository.findAll();

	}

	// encontrando cliente por id
	@GetMapping("/clientes/{id}")
	public Cliente findCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	// inserir no bd um objeto do tipo cliente
	public Cliente insertCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//deletando cliente
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	//update clietne
	public Cliente updateCliente(Long id, Cliente cliente) {
		Cliente entity = clienteRepository.getOne(id);
		updateData(entity, cliente);
		return clienteRepository.save(entity);
	}

	private void updateData(Cliente entity, Cliente cliente) {
		
		entity.setNome(cliente.getNome());
		entity.setEmail(cliente.getEmail());
		
	}

}
