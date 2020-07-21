package dev.elton.library.system.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
