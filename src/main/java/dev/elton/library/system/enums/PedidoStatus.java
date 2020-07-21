package dev.elton.library.system.enums;

public enum PedidoStatus {
	
	ALUGADO(1), 
	RESERVADO(2),
	DISPONIVEL(3),
	CANCELADO(4);
	
	private int codigo;
	
	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static PedidoStatus valueOf(int codigo) {
		for(PedidoStatus valor : PedidoStatus.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
				
		}
		
		throw new IllegalArgumentException("Codigo invalido!");
	}

}
