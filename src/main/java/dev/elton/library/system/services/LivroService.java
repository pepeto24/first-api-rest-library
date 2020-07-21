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

import dev.elton.library.system.entities.Livro;
import dev.elton.library.system.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	// CRUD p/ Manter livro

	// encontrando/listando todos os livros

	@GetMapping("/livros")
	public List<Livro> findAll() {
		return livroRepository.findAll();

	}
	
	//encontrando livros por id
	@GetMapping("/livros/{id}")
	public Livro findLivro(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.get();
	}
	
	//deletando livro
	@DeleteMapping("/livros/{id}")
	public void deleteLivro(@PathVariable long id) {
		livroRepository.deleteById(id);
	}
	
	//criando livro
	
	@PostMapping("/livros")
	public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
		Livro livroSalvo = livroRepository.save(livro);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(livroSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//dando update no livro
	
	public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro, @PathVariable long id){
		Optional<Livro> livroOptional = livroRepository.findById(id);
		
		if(!livroOptional.isPresent()) {
			return ResponseEntity.notFound().build(); //retornando parametro sem body
		}
		
		livro.setId(id);
		livroRepository.save(livro);
		
		return ResponseEntity.noContent().build();
	}
	
	


}
