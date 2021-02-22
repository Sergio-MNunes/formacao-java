package br.com.caelum.leilao.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void UsuarioNaoPodeDarDoisLancesSeguidos() {
		
		Usuario u1 = new Usuario(1, "Sergio");

		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u1, 5000);
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		
		Assert.assertEquals(1, leilao.getLances().size(), 0);
	}
	
	@Test
	public void UsuarioNaoPodeDarMaisDeCincoLances() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Lucas");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 5000);
		Lance lance3 = new Lance(u1, 4600);
		Lance lance4 = new Lance(u2, 1450);
		Lance lance5 = new Lance(u1, 2345);
		Lance lance6 = new Lance(u2, 5324);
		Lance lance7 = new Lance(u1, 2740);
		Lance lance8 = new Lance(u2, 8267);
		Lance lance9 = new Lance(u1, 1853);
		Lance lance10 = new Lance(u2, 3500);
		Lance lance11 = new Lance(u1, 32134);
		
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.propoe(lance4);
		leilao.propoe(lance5);
		leilao.propoe(lance6);
		leilao.propoe(lance7);
		leilao.propoe(lance8);
		leilao.propoe(lance9);
		leilao.propoe(lance10);
		leilao.propoe(lance11);
		
		Assert.assertEquals(10, leilao.getLances().size(), 0);
	}
	
	@Test
	public void UsuarioDobraOSeuUltimoLance() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Bruno");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 4000);
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(6000, leilao.getUltimoLance().getValor(), 0.00001);
	}
	
	@Test
	public void DobraUltimoLanceComDoisLancesSeguidosDoUsuario() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Bruno");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 5000);
		Lance lance3 = new Lance(u1, 6000);
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(6000, leilao.getUltimoLance().getValor(), 0.00001);
	}
	
	@Test
	public void DobraUltimoLanceSemNenhumLance() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.dobraUltimoLance(u1);
		
		Assert.assertEquals(0, leilao.getLances().size());
	}
}
