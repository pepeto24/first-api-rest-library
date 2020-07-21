package dev.elton.library.system.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.elton.library.system.entities.pk.PedidoItemPK;

@Entity
@Table(name = "pedido_item")
public class PedidoItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();
	
	private Integer quantidade;
	private Double valor;
	
	public PedidoItem() {
		//default
	}

	public PedidoItem(Pedido pedido, Livro livro, Integer quantidade, Double valor) {
		super();
		id.setPedido(pedido);
		id.setLivro(livro);
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	
	public Livro getLivro() {
		return id.getLivro();
	}
	
	public void setLivro(Livro livro) {
		id.setLivro(livro);
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
