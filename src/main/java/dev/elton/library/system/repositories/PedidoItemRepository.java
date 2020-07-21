package dev.elton.library.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elton.library.system.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
