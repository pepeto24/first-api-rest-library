package dev.elton.library.system.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.elton.library.system.entities.Pedido;
import dev.elton.library.system.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
		@Autowired
		private PedidoService pedidoService;
	
		@GetMapping
		public ResponseEntity<List<Pedido>> findAll(){
			List<Pedido> list = pedidoService.findAll();
			
			return ResponseEntity.ok().body(list); //retorna a resposta com sucesso no http e retorna o corpo da resposta do Pedido u
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Pedido> findPedido(@PathVariable Long id){
			Pedido pedido = pedidoService.findPedido(id);
			
			return ResponseEntity.ok().body(pedido);
		}
		
		@PostMapping
		public ResponseEntity<Pedido> insertPedido(@RequestBody Pedido pedido){
			pedido = pedidoService.insertPedido(pedido);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
			
			return ResponseEntity.created(uri).body(pedido);
		}
		
		//end point para deletar o pedido
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deletePedido(@PathVariable Long id){
			pedidoService.deletePedido(id);
			
			return ResponseEntity.noContent().build();
		}
		
		//end point pra atualizar o pedido
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido){
			
			pedido = pedidoService.updatePedido(id, pedido);
			return ResponseEntity.ok().body(pedido);
		}


}
