package dev.elton.library.system.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elton.library.system.entities.Reserva;
import dev.elton.library.system.services.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {
	
	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public ResponseEntity<List<Reserva>> findAll(){
		List<Reserva> list = reservaService.findAll();
		
		return ResponseEntity.ok().body(list); //retorna a resposta com sucesso no http e retorna o corpo da resposta do Cliente u
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reserva> findCliente(@PathVariable Long id){
		Reserva reserva = reservaService.findReserva(id);
		
		return ResponseEntity.ok().body(reserva);
	}


}
