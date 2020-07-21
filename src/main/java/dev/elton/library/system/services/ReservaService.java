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

import dev.elton.library.system.entities.Reserva;
import dev.elton.library.system.repositories.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	// CRUD p/ Manter reserva etc

	// encontrando/listando todos as reservas

	@GetMapping("/reservas")
	public List<Reserva> findAll() {
		return reservaRepository.findAll();

	}
	
	//encontrando reservas por id
	@GetMapping("/reservas/{id}")
	public Reserva findReserva(@PathVariable Long id) {
		Optional<Reserva> reserva = reservaRepository.findById(id);
		return reserva.get();
	}
	
	//deletando livro
	@DeleteMapping("/reservas/{id}")
	public void deleteLivro(@PathVariable long id) {
		reservaRepository.deleteById(id);
	}
	
	//criando livro
	
	@PostMapping("/reservas")
	public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva){
		Reserva reservaSalvo = reservaRepository.save(reserva);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(reservaSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//dando update no livro
	
	public ResponseEntity<Reserva> updateLivro(@RequestBody Reserva reserva, @PathVariable long id){
		Optional<Reserva> reservaOptional = reservaRepository.findById(id);
		
		if(!reservaOptional.isPresent()) {
			return ResponseEntity.notFound().build(); //retornando parametro sem body
		}
		
		reserva.setId(id);
		reservaRepository.save(reserva);
		
		return ResponseEntity.noContent().build();
	}

}
