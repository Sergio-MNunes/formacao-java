package br.com.caelum.leilao.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Leiloeiro;
import br.com.caelum.leilao.dominio.Usuario;


public class LeiloeiroTest {
	
	private Usuario u1;
	private Usuario u2;
	private Usuario u3;
	private Usuario u4;
	private Usuario u5;
	private Usuario u6;
	private Usuario u7;
	private Usuario u8;
	private Usuario u9;
	private Usuario u10;
	private Leiloeiro execLeilao;

	@BeforeClass // Executa apenas uma vez antes da classe de LeiloeiroTest
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass // Executa apenas uma vez antes da classe de LeiloeiroTest
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	
	@Before // Executa sempre antes de cada metodo
	public void setUp() {
		u1 = new Usuario(1, "Sergio");
		u2 = new Usuario(2, "Bruno");
		u3 = new Usuario(3, "Thainan");
		u4 = new Usuario(4, "João");
		u5 = new Usuario(5, "Maria");
		u6 = new Usuario(6, "Rodolfo");
		u7 = new Usuario(7, "Maiara");
		u8 = new Usuario(8, "Maraisa");
		u9 = new Usuario(9, "Penelope");
		u10 = new Usuario(10, "Lucas");
		
		execLeilao = new Leiloeiro();
	}
	
	@After // Executa ao fim de todos os metodos
	public void testandoAfter() {
	  
	}
	
	@Test
	public void testeMaiorEMenor() {
				
		Leilao leilao = new LeilaoFactory().criaLeilao("qwe")
				.darLance(u1, 3000)
				.darLance(u2, 4600)
				.darLance(u3, 5000)
				.constroi();
		
		execLeilao.avaliaLeilao(leilao);
		
		Assert.assertEquals(3000, execLeilao.getMenorLance(), 0.0001);
		Assert.assertEquals(5000, execLeilao.getMaiorLance(), 0.0001);
		
	}
	
	@Test
	public void testaCincoMaiores() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u2, 5000)
				.darLance(u3, 4600)
				.darLance(u4, 1450)
				.darLance(u5, 2345)
				.darLance(u6, 5324)
				.darLance(u7, 2740)
				.darLance(u8, 8267)
				.darLance(u9, 1853)
				.darLance(u10, 3500)
				.constroi();

		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(8267, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(5324, cincoMaioresLances.get(1).getValor(), 0.00001);
		Assert.assertEquals(5000, cincoMaioresLances.get(2).getValor(), 0.00001);
		Assert.assertEquals(4600, cincoMaioresLances.get(3).getValor(), 0.00001);
		Assert.assertEquals(3500, cincoMaioresLances.get(4).getValor(), 0.00001);
	}
	
	@Test
	public void testeCincoMaioresComMenosDeCincoLances() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.darLance(u2, 4600)
				.darLance(u3, 5000)
				.constroi();
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(5000, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(4600, cincoMaioresLances.get(1).getValor(), 0.00001);
		Assert.assertEquals(3000, cincoMaioresLances.get(2).getValor(), 0.00001);
		
		Assert.assertEquals(3, cincoMaioresLances.size(), 0);
	}
	
	@Test
	public void avaliaLeilaoComApenasUmLance() {
		
		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.darLance(u1, 3000)
				.constroi();
		
		execLeilao.avaliaLeilao(leilao);
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(3000, cincoMaioresLances.get(0).getValor(), 0.00001);
		Assert.assertEquals(1, cincoMaioresLances.size(), 0);
		
		Assert.assertEquals(3000, execLeilao.mediaDosLances(leilao), 0.00001);
		
		Assert.assertEquals(3000, execLeilao.getMenorLance(), 0.0001);
		Assert.assertEquals(3000, execLeilao.getMaiorLance(), 0.0001);
	}
	
	// O teste abaixo espera receber uma excecao, ou seja, se a excecao for recebida, o teste eh bem sucedido
	@Test(expected=RuntimeException.class)
	public void avaliaLeilaoComNenhumLance() {

		Leilao leilao = new LeilaoFactory().criaLeilao("Playstation 5")
				.constroi();
		
		execLeilao.avaliaLeilao(leilao);
		
		List<Lance> cincoMaioresLances = execLeilao.getCincoMaioresLances(leilao);
		
		Assert.assertEquals(0, execLeilao.mediaDosLances(leilao), 0);
		Assert.assertEquals(0, cincoMaioresLances.size(), 0);
		Assert.assertEquals(0, execLeilao.getMenorLance(), 0);
		Assert.assertEquals(0, execLeilao.getMaiorLance(), 0);
	}
}