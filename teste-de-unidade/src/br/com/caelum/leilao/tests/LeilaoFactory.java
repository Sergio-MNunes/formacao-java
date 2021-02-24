package br.com.caelum.leilao.tests;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

// Classes como esta, utilizadas para facilitar a criacao dos cenarios dos nossos testes, sao chamadas de Tests Data Builders
public class LeilaoFactory {

	private Leilao leilao;
	
	public LeilaoFactory criaLeilao(String produto) {
		this.leilao = new Leilao(produto);
		return this;
	}
	
	public LeilaoFactory darLance(Usuario usuario, double valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}
	
	public Leilao constroi() {
		return this.leilao;
	}
}