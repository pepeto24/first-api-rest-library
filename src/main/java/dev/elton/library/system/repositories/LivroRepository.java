package dev.elton.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elton.library.system.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
