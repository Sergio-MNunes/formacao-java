package br.com.caelum.leilao.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;


public class LeilaoTest {
	
	private Usuario u1;
	private Usuario u2;

	@Before
	public void setUp() {
		u1 = new Usuario(1, "Sergio");
		u2 = new Usuario(2, "Bruno");
	}
	
	@Test
	public void usuarioNaoPodeDarDoisLancesSeguidos() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u1, 5000)
				.constroi();

		Assert.assertEquals(1, leilao.getLances().size(), 0);
	}
	
	@Test
	public void usuarioNaoPodeDarMaisDeCincoLances() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u2, 5000)
				.darLance(u1, 4600)
				.darLance(u2, 1450)
				.darLance(u1, 2345)
				.darLance(u2, 5324)
				.darLance(u1, 2740)
				.darLance(u2, 8267)
				.darLance(u1, 1853)
				.darLance(u2, 3500)
				.darLance(u1, 32134)
				.constroi();
		
		Assert.assertEquals(10, leilao.getLances().size(), 0);
	}
	
	@Test
	public void usuarioDobraOSeuUltimoLance() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u2, 4000)
				.constroi();
		
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(6000, leilao.getUltimoLance().getValor(), 0.00001);
	}
	
	@Test
	public void dobraUltimoLanceComDoisLancesSeguidosDoUsuario() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u2, 5000)
				.darLance(u1, 6000)
				.constroi();
		
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(6000, leilao.getUltimoLance().getValor(), 0.00001);
	}
	
	@Test
	public void dobraUltimoLanceSemNenhumLance() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5").constroi();
		
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(0, leilao.getLances().size());
	}
}
