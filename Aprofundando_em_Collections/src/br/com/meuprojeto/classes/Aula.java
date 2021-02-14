package br.com.meuprojeto.classes;

public class Aula implements Comparable<Aula> {
	private int id;
	private String titulo;
	private int duracao;
	
	public Aula(int id, String nome, int duracao) {
		this.id = id;
		this.titulo = nome;
		this.duracao = duracao;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	@Override
	public String toString() {
		return "[aula " + this.id + ": " + this.titulo + ", " + this.duracao + " minutos]";
	}

	@Override
	public int compareTo(Aula outraAula) {
		return this.titulo.compareTo(outraAula.getNome());
	}
}
