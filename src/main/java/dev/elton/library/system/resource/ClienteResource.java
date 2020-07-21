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
		
		@PostMapping
		public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
			cliente = clienteService.insertCliente(cliente);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
			
			return ResponseEntity.created(uri).body(cliente);
		}
		
		//end point para deletar o cliente
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
			clienteService.deleteCliente(id);
			
			return ResponseEntity.noContent().build();
		}
		
		//end point pra atualizar o cliente
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
			
			cliente = clienteService.updateCliente(id, cliente);
			return ResponseEntity.ok().body(cliente);
		}

}
