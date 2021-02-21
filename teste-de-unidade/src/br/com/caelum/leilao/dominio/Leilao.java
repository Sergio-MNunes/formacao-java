package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance novoLance) {
		int lancesDoUsuario = contaLances(novoLance.getUsuario());

		if (!lances.isEmpty() && (validaLanceConsecutivo(novoLance.getUsuario()) || lancesDoUsuario >= 5)) return;
		
		lances.add(novoLance);
	}

	private int contaLances(Usuario usuario) {
		int qtdeDeLances = (int) lances.stream()
			.filter(lance -> lance.getUsuario() == usuario)
			.count();
		return qtdeDeLances;
	}

	private boolean validaLanceConsecutivo(Usuario usuario) {
		return getUltimoLance().getUsuario().equals(usuario);
	}

	public Lance getUltimoLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
}
