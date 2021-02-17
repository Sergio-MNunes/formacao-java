package br.com.meuprojeto.testes;

import br.com.meuprojeto.classes.Aluno;
import br.com.meuprojeto.classes.Curso;

public class TestandoMaps {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno("Sergio de Magalhaes Nunes", 1111);
		Aluno aluno2 = new Aluno("Daniel Bou de Souza", 2222);
		Aluno aluno3 = new Aluno("Thais Maciel de Almeida", 3333);
		Aluno aluno4 = new Aluno("Lucas Bruno Bezerra", 4444);
		Aluno aluno5 = new Aluno("Edilson Belo da Silva", 5555);
		Aluno aluno6 = new Aluno("Bruno Fernando Correa de Abreu", 6666);
		
		Curso cursoDeColecoes = new Curso("Java Collections", "Paulo Silveira");
		
		cursoDeColecoes.matricula(aluno1);
		cursoDeColecoes.matricula(aluno2);
		cursoDeColecoes.matricula(aluno3);
		cursoDeColecoes.matricula(aluno4);
		cursoDeColecoes.matricula(aluno5);
		cursoDeColecoes.matricula(aluno6);
		
		System.out.println(cursoDeColecoes.getAlunos());
		System.out.println();
		System.out.println("Matricula encontrada: ");
		System.out.println(cursoDeColecoes.procuraMatricula(3333)); // Retorna o aluno com a matricula pesquisada, ou um NoSuchElementException caso a matricula nao exista
		
		Aluno aluno7 = new Aluno("Thainan Fuza de Oliveira", 3333); // Adicionando um novo aluno com matricula ja existente para ver o comportamento do Map
		cursoDeColecoes.matricula(aluno7);
		

		// Repare que a matricula 3333 mudou o seu valor associado a ela.
		// Caso uma chave que ja exista no map seja adicionada novamente, ele ira substituir o valor para aquela chave ja existente, e o valor antigo sera perdido.
		System.out.println();
		System.out.println("Matricula encontrada: ");
		System.out.println(cursoDeColecoes.procuraMatricula(3333)); 
		
	}
}
