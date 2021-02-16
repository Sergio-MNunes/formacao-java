package br.com.meuprojeto.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestandoSets {

	public static void main(String[] args) {
		String aluno1 = "Sergio de Magalhaes Nunes";
		String aluno2 = "Daniel Bou de Souza";
		String aluno3 = "Thais Maciel de Almeida";
		String aluno4 = "Lucas Bruno Bezerra";
		String aluno5 = "Edilson Belo da Silva";
		String aluno6 = "Bruno Fernando Correa de Abreu";
		
		Set<String> alunos = new HashSet<>(); // Cria um conjunto de alunos (conjunto = set)
		
		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);
		alunos.add(aluno5);
		alunos.add(aluno6);
		
		// Repare que a ordem impressa eh diferente da ordem que os alunos foram inseridos
		System.out.println(alunos); 
		System.out.println();
		
		// Repare melhor. Isso acontece porque, ao contrario das Lists, os Sets nao controlam a ordem de seus elementos.
		// Eles estao jogados la dentro, como numa sacola, aleatorios.
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		System.out.println();
		
		// "E se eu quiser ordenar os elementos dentro de um set?"
		// Entao e necessario criar uma list a partir deste set, utilizando o construtor do ArrayList ou LinkedList
		List<String> listaImagemDoSet = new ArrayList<>(alunos);
		Collections.sort(listaImagemDoSet);
		
		// Agora a lista esta ordenada (lembrando que esta eh a maneira com lambda de percorrer uma lista)
		listaImagemDoSet.forEach(elemento -> {
			System.out.println(elemento); 
		}); 
		System.out.println();
		
		// A principal vantagem dos sets sobre as lists eh que eles sao muito mais performaticos para operacoes de busca.
		System.out.println(alunos.contains("Lucas Bruno Bezerra"));
		System.out.println();
		
		// Veja o tamanho do set
		System.out.println(alunos.size()); 
		
		alunos.add("Daniel Bou de Souza");
		
		// Veja novamente apos adicionar um novo elemento. Continua o mesmo tamanho, pois os Sets nao aceitam elementos iguais. Outra diferenca deles pras Lists.
		System.out.println(alunos.size()); 
		
		System.out.println();
		System.out.println("**Percorrendo um Set no Java 8**");
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println();
		System.out.println("**Percorrendo um Set no Java 5**");
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		// Toda Collection possui um metodo iterator() que retorna um objeto Iterator, utilizado antigamente para iterar seus componentes.
		System.out.println();
		System.out.println("**Percorrendo um Set no Java 2**");
		Iterator<String> iteradorAlunos = alunos.iterator(); 
		while (iteradorAlunos.hasNext()) {
			System.out.println(iteradorAlunos.next());
		} // Quando o Iterator chega no ultimo elemento da Collection de onde foi gerado, ele se torna inutilizavel. Para percorrer novamente, eh necessario criar um novo Iterator.
		
	}
}
