package dev.elton.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elton.library.system.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
