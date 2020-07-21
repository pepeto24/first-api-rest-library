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

import dev.elton.library.system.entities.Pedido;
import dev.elton.library.system.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	// CRUD p/ Manter pedido

	// encontrando/listando todos os pedidos

	@GetMapping("/pedidos")
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();

	}
	
	//encontrando pedido por id
	@GetMapping("/pedidos/{id}")
	public Pedido findPedido(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.get();
	}
	
	//deletando pedido
	@DeleteMapping("/pedidos/{id}")
	public void deletePedido(@PathVariable long id) {
		pedidoRepository.deleteById(id);
	}
	
	//criando pedido
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(pedidoSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//dando update no pedido
	
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido, @PathVariable long id){
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
		
		if(!pedidoOptional.isPresent()) {
			return ResponseEntity.notFound().build(); //retornando parametro sem body
		}
		
		pedido.setId(id);
		pedidoRepository.save(pedido);
		
		return ResponseEntity.noContent().build();
	}

	
	
	
}
