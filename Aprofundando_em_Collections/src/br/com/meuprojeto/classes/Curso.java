package br.com.meuprojeto.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>(); // Tratando a referencia como um List, podemos usufruir do polimorfismo quando lidamos com o objeto fora da classe.
	private Set<Aluno> alunosMatriculados = new HashSet<>(); // Sets nao possuem ordem de elementos, porem sao mais performaticos do que lista para algumas operacoes.
	private Map<Integer, Aluno> deMatriculaParaAluno = new HashMap<>(); // Maps permitem mapear chave e valor, igual dicionario no python. 
	
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
	
	public void adicionaAula(Aula aula) {
		this.aulas.add(aula);
	}
	
	public Set<Aluno> getAlunos(){ // Da mesma forma como o metodo acima retorna uma list, este retorna um set.
		return Collections.unmodifiableSet(this.alunosMatriculados); // Tambem retorna um objeto nao modificavel, como acima.
	}
	
	public void matricula(Aluno aluno) {
		this.alunosMatriculados.add(aluno);
		this.deMatriculaParaAluno.put(aluno.getMatricula(), aluno);
		// Todo aluno matriculado, alem de ser adicionado ao conjunto de alunos, tambem eh adicionado ao Map com a matricula como chave e o Aluno como valor.
		// Desta forma, podemos buscar um aluno a partir de sua matricula por exemplo, coisa que antes nao podiamos apenas com o Set.
	}
	
	public Aluno procuraMatricula(int matricula) {
		if (!this.deMatriculaParaAluno.containsKey(matricula)) { // Se a matricula recebida por parametro nao existe no Map, joga um NoSuchElementException
			throw new NoSuchElementException("Matrícula não encontrada");
		}		
		return deMatriculaParaAluno.get(matricula); // Caso exista, retorna o valor atribuido a chave matricula buscada.
	}

	public int getTempoTotal() {
		int tempoTotal = 0;
		for(Aula aula : this.aulas) {
			tempoTotal += aula.getDuracao();
		}
		return tempoTotal;
	}
	
	// O metodoo forEach() do map recebe um argumento BiConsumer, enquanto as demais colecoes costumam receber Consumer.
	// A diferenca eh que o BiConsumer trabalha com dois argumentos. Veja a assinatura do forEach() de map:
	// default void forEach(BiConsumer<? super K, ? super V> action)
	// Traduzindo, o forEach recebe uma interface funcional BiConsumer, que eh generic. O primeiro tipo tem que ser maior que K e o segundo maior que V (maior no sentido
	// de que precisam ser superclasses de K e V respectivamente, ou seja, pode ser K e V, ou K e V precisam herdar delas.
	public void imprimeMap() {
		deMatriculaParaAluno.forEach((matricula, aluno) -> System.out.println(matricula + " " + aluno));
	}
	
	@Override
	public String toString() {
		return "[Curso: " + this.nome + ", por " + this.instrutor + ". Duração: " + this.getTempoTotal() + " minutos]";
	}
}
