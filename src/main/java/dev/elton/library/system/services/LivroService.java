package dev.elton.library.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

	// encontrando livros por id
	@GetMapping("/livros/{id}")
	public Livro findLivro(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.get();
	}

	// inserir no bd um objeto do tipo livro
	public Livro insertLivro(Livro cliente) {
		return livroRepository.save(cliente);
	}

	// deletando livro
	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}

	// update livro
	public Livro updateLivro(Long id, Livro cliente) {
		Livro entity = livroRepository.getOne(id);
		updateData(entity, cliente);
		return livroRepository.save(entity);
	}

	private void updateData(Livro entity, Livro livro) {

		entity.setTitulo(livro.getTitulo());
		entity.setDescricao(livro.getDescricao());
		entity.setEditora(livro.getEditora());
		entity.setValor(livro.getValor());
		entity.setAutor(livro.getAutor());
		entity.setAno(livro.getAno());
	}

}
