package br.com.caelum.leilao.dominio;

import java.security.InvalidParameterException;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		
		if(valor <= 0) throw new IllegalArgumentException("O valor do lance tem que ser maior que zero.");
		
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "[ID do comprador: " + this.usuario.getId() + ", lance: " + this.valor + "]";
	}
}
