package dev.elton.library.system.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		return ResponseEntity.ok().body(list); //retorna a resposta com sucesso no http e retorna o corpo da resposta do Cliente u
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findCliente(@PathVariable Long id){
		Livro livro = livroService.findLivro(id);
		
		return ResponseEntity.ok().body(livro);
	}

	
}
