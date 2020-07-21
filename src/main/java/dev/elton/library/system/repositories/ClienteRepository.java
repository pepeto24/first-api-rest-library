package dev.elton.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elton.library.system.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
