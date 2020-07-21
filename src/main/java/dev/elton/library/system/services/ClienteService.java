package dev.elton.library.system.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//encontrando cliente por id
	@GetMapping("/clientes/{id}")
	public Cliente findCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	//deletando cliente
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable long id) {
		clienteRepository.deleteById(id);
	}
	
	//criando cliente
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(clienteSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//dando update no cliente
	
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable long id){
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		
		if(!clienteOptional.isPresent()) {
			return ResponseEntity.notFound().build(); //retornando parametro sem body
		}
		
		cliente.setId(id);
		clienteRepository.save(cliente);
		
		return ResponseEntity.noContent().build();
	}

	
	
	
}
