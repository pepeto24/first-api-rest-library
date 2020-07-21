package dev.elton.library.system.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elton.library.system.entities.Cliente;
import dev.elton.library.system.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
		@Autowired
		private ClienteService clienteService;
	
		@GetMapping
		public ResponseEntity<List<Cliente>> findAll(){
			List<Cliente> list = clienteService.findAll();
			
			return ResponseEntity.ok().body(list); //retorna a resposta com sucesso no http e retorna o corpo da resposta do Cliente u
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Cliente> findCliente(@PathVariable Long id){
			Cliente cliente = clienteService.findCliente(id);
			
			return ResponseEntity.ok().body(cliente);
		}

}
