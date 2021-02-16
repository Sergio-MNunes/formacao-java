package br.com.meuprojeto.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>(); // Tratando a referencia como um List, podemos usufruir do polimorfismo quando lidamos com o objeto fora da classe.
	private Set<Aluno> alunosMatriculados = new HashSet<>(); // Sets nao possuem ordem de elementos, porem sao mais performaticos do que lista para algumas operacoes.
	
	public Curso (String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getInstrutor() {
		return this.instrutor;
	}
	
	public List<Aula> getAulas() { // O metodo retorna uma List, desta forma, nao importa se sera recebido por um ArrayList ou um LinkedList, funcionara da mesma forma.
		return Collections.unmodifiableList(this.aulas); // Este metodo da classe Collections retorna a lista passada como parametro de forma read only.
														 // Desta forma, nao sera possivel manipular a lista atraves do getAulas().
														 // A linha de codigo abaixo daria erro de compilacao, por exemplo:
														 // meuCurso.getAulas().add(new Aula(1, "nome qualquer de aula", 23));
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public Set<Aluno> getAlunos(){ // Da mesma forma como o metodo acima retorna uma list, este retorna um set.
		return Collections.unmodifiableSet(this.alunosMatriculados); // Tambem retorna um objeto nao modificavel, como acima.
	}
	
	public void matricula(Aluno aluno) {
		this.alunosMatriculados.add(aluno);
	}

	public int getTempoTotal() {
		int tempoTotal = 0;
		for(Aula aula : this.aulas) {
			tempoTotal += aula.getDuracao();
		}
		return tempoTotal;
	}
	
	@Override
	public String toString() {
		return "[Curso: " + this.nome + ", por " + this.instrutor + ". Duração: " + this.getTempoTotal() + " minutos]";
	}
}
