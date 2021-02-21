package br.com.caelum.leilao.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Leiloeiro;
import br.com.caelum.leilao.dominio.Usuario;


public class LeiloeiroTest {
	
	@Test
	public void TesteMaiorEMenor() {
				
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Lucas");
		Usuario u3 = new Usuario(3, "Bruno");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 4600);
		Lance lance3 = new Lance(u3, 5000);
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		Leiloeiro execLeilao = new Leiloeiro();
		
		execLeilao.avaliaLeilao(leilao);
		
		Assert.assertEquals(3000, execLeilao.getMenorLance(), 0.0001);
		Assert.assertEquals(5000, execLeilao.getMaiorLance(), 0.0001);
		
	}
	
	@Test
	public void TestaCincoMaiores() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Lucas");
		Usuario u3 = new Usuario(3, "Bruno");
		Usuario u4 = new Usuario(4, "Thainan");
		Usuario u5 = new Usuario(5, "João");
		Usuario u6 = new Usuario(6, "Maria");
		Usuario u7 = new Usuario(7, "Rodolfo");
		Usuario u8 = new Usuario(8, "Maiara");
		Usuario u9 = new Usuario(9, "Maraisa");
		Usuario u10 = new Usuario(10, "Penelope");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 5000);
		Lance lance3 = new Lance(u3, 4600);
		Lance lance4 = new Lance(u4, 1450);
		Lance lance5 = new Lance(u5, 2345);
		Lance lance6 = new Lance(u6, 5324);
		Lance lance7 = new Lance(u7, 2740);
		Lance lance8 = new Lance(u8, 8267);
		Lance lance9 = new Lance(u9, 1853);
		Lance lance10 = new Lance(u10, 3500);
		
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
		
		Leiloeiro execLeilao = new Leiloeiro();
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(8267, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(5324, cincoMaioresLances.get(1).getValor(), 0.00001);
		Assert.assertEquals(5000, cincoMaioresLances.get(2).getValor(), 0.00001);
		Assert.assertEquals(4600, cincoMaioresLances.get(3).getValor(), 0.00001);
		Assert.assertEquals(3500, cincoMaioresLances.get(4).getValor(), 0.00001);
	}
	
	@Test
	public void TesteCincoMaioresComMenosDeCincoLances() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		Usuario u2 = new Usuario(2, "Lucas");
		Usuario u3 = new Usuario(3, "Bruno");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		Lance lance2 = new Lance(u2, 5000);
		Lance lance3 = new Lance(u3, 4600);
		
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		Leiloeiro execLeilao = new Leiloeiro();
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(5000, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(4600, cincoMaioresLances.get(1).getValor(), 0.00001);
		Assert.assertEquals(3000, cincoMaioresLances.get(2).getValor(), 0.00001);
		
		Assert.assertEquals(3, cincoMaioresLances.size(), 0);
	}
	
	@Test
	public void LeilaoComApenasUmLance() {
		
		Usuario u1 = new Usuario(1, "Sergio");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Lance lance1 = new Lance(u1, 3000);
		
		leilao.propoe(lance1);
		
		Leiloeiro execLeilao = new Leiloeiro();
		execLeilao.avaliaLeilao(leilao);
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(3000, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(3000, execLeilao.mediaDosLances(leilao), 0.00001);
		Assert.assertEquals(1, cincoMaioresLances.size(), 0);
		Assert.assertEquals(3000, execLeilao.getMenorLance(), 0.0001);
		Assert.assertEquals(3000, execLeilao.getMaiorLance(), 0.0001);
	}
	
	@Test
	public void LeilaoComNenhumLance() {
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Leiloeiro execLeilao = new Leiloeiro();
		execLeilao.avaliaLeilao(leilao);
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(0, execLeilao.mediaDosLances(leilao), 0);
		Assert.assertEquals(0, cincoMaioresLances.size(), 0);
		Assert.assertEquals(0, execLeilao.getMenorLance(), 0);
		Assert.assertEquals(0, execLeilao.getMaiorLance(), 0);
	}
}