package br.com.caelum.leilao.tests;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Usuario;

public class LanceTest {

	private Usuario u1;
	
	@Before
	public void werwe() {
		u1 = new Usuario(1, "Sergio");
	}
	
	// O teste abaixo espera receber uma excecao, ou seja, se a excecao for recebida, o teste eh bem sucedido
	@Test (expected=IllegalArgumentException.class)
	public void testaLanceComValorZero() {
		new LeilaoFactory().criaLeilao("Playstation 5")
			.darLance(u1, 0);
	}
	
	// O teste abaixo espera receber uma excecao, ou seja, se a excecao for recebida, o teste eh bem sucedido
	@Test (expected=IllegalArgumentException.class)
	public void testaLanceComValorNegativo() {
		new LeilaoFactory().criaLeilao("Playstation 5")
			.darLance(u1, -300);
	}
}