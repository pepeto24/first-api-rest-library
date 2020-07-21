package dev.elton.library.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	// inserir no bd um objeto do tipo pedido
	public Pedido insertPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	// deletando pedido
	public void deletePedido(Long id) {
		pedidoRepository.deleteById(id);
	}

	// update pedido
	public Pedido updatePedido(Long id, Pedido pedido) {
		Pedido entity = pedidoRepository.getOne(id);
		updateData(entity, pedido);
		return pedidoRepository.save(entity);
	}

	//update no status do pedido
	private void updateData(Pedido entity, Pedido pedido) {
		
		entity.setPedidoStatus(pedido.getPedidoStatus());
		
	}
	
	
	
	
}
