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

import dev.elton.library.system.entities.Livro;
import dev.elton.library.system.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = livroService.findAll();
		
		return ResponseEntity.ok().body(list); //retorna a resposta com sucesso no http e retorna o corpo da resposta do Livro u
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findLivro(@PathVariable Long id){
		Livro livro = livroService.findLivro(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@PostMapping
	public ResponseEntity<Livro> insertLivro(@RequestBody Livro livro){
		livro = livroService.insertLivro(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).body(livro);
	}
	
	//end point para deletar o livro
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Long id){
		livroService.deleteLivro(id);
		
		return ResponseEntity.noContent().build();
	}
	
	//end point pra atualizar o livro
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livro){
		
		livro = livroService.updateLivro(id, livro);
		return ResponseEntity.ok().body(livro);
	}

	
}
