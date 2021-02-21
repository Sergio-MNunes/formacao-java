package br.com.caelum.leilao.tests;

import java.util.List;

import org.junit.Assert;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Leiloeiro;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteManual {
	public static void main(String[] args) {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Leilao leilao = new Leilao("Playstation 5");
		Lance lance1 = new Lance(u1, 3000);
		
		leilao.propoe(lance1);
		
		Leiloeiro execLeilao = new Leiloeiro();
		
		System.out.println(execLeilao.getMenorLance());
		
	}
}
