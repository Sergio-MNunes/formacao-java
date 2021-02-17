package br.com.meuprojeto.testes;

import br.com.meuprojeto.classes.Aluno;
import br.com.meuprojeto.classes.Curso;

public class TesteAluno {

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
		
		cursoDeColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});
		
		
		// *** equals() e hashCode() ***
		Aluno alunoNovo = new Aluno("Sergio de Magalhaes Nunes", 1111);
		
		System.out.println();
		System.out.println("Vendo se o novo aluno é igual ao aluno1, seguindo as regras definidas no equals() da classe Aluno: ");
		System.out.println(aluno1.equals(alunoNovo));
		
		// para a sentenca abaixo dar true, a classe aluno precisa possuir, alem do metodo equals(), o metodo hashCode(), devido a comportamentos internos do set
		System.out.println();
		System.out.println("Vendo se o conjunto contem um objeto igual a 'anolunoNovo': ");
		System.out.println(cursoDeColecoes.getAlunos().contains(alunoNovo));
		
		System.out.println(aluno1.hashCode());
		System.out.println(alunoNovo.hashCode());
	}
}
