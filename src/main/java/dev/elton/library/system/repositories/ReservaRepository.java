package dev.elton.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elton.library.system.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
