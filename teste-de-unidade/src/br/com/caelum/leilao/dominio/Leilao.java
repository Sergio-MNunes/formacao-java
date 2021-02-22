package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Leilao {

	
	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance novoLance) {
		
		if (!lances.isEmpty() && naoPodeDarLance(novoLance.getUsuario())) return;
		
		lances.add(novoLance);
	}

	private boolean naoPodeDarLance(Usuario usuario) {
		return lancesConsecutivos(usuario) || contaLances(usuario) >= 5;
	}

	private int contaLances(Usuario usuario) {
		int qtdeDeLances = (int) lances.stream()
			.filter(lance -> lance.getUsuario() == usuario)
			.count();
		return qtdeDeLances;
	}

	private boolean lancesConsecutivos(Usuario usuario) {
		return getUltimoLance().getUsuario().equals(usuario);
	}

	public Lance getUltimoLance() {
		return lances.get(lances.size() - 1);
	}
	
	public Lance getUltimoLance(Usuario usuario) {
		List<Lance> lancesDoUsuario = lances.stream()
				.filter(lance -> lance.getUsuario().equals(usuario))
				.collect(Collectors.toList());
		
		return lancesDoUsuario.get(lancesDoUsuario.size() -1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobraUltimoLance(Usuario usuario) {
		if(lances.isEmpty()) return;
		Lance ultimoLanceDobrado = new Lance(usuario, getUltimoLance(usuario).getValor() * 2);
		
		this.propoe(ultimoLanceDobrado);
	}	
}
