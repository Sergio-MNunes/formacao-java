import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

// As situacoes do programa A indicam que podemos usar classes anonimas, pois estamos criando classes (ConsomeNomes e ComparaNomesOrdemAlfabetica)
// para usar apenas uma unica vez, para imprimir os nomes da lista ou ordenar ela de acordo com o criterio definido.

// ***PS: o codigo abaixo nao utiliza de boa pratica. Talvez para o dado cenario ate fosse mais interessante utilizar a ConsomeNomes() do programa A, pois ele aparece
// diversas vezes. Aqui foi feito desta forma apenas para fins didaticos.

// As classes anonimas suprem a necessidade de criar uma classe que se utiliza apenas uma unica vez, para economizar codigo. Ela eh criada dentro do metodo
// que utilizara a classe e ela morre ali mesmo. 

// O codigo A ficaria desta forma, se fosse escrito com classes anonimas

public class BClassesAnonimas {
	public static void main(String[] args) {
		
		List<String> nomes = new ArrayList<>();
	
		nomes.add("Sergio de Magalhaes Nunes");
		nomes.add("Paulo Henrique Hirata Nunes");
		nomes.add("Lucas Bruno Bezerra");
		nomes.add("Thainan Fuza de Oliveira");
		nomes.add("Bruno Fernando Correa de Abreu");
		nomes.add("Elisangela de Magalhaes");
		
		System.out.println("1 - A ordem de inserção da nossa lista é:");
		
		// Classe anonima de Consumer. Como eh uma classe utilizada apenas aqui, o compilador nao quer saber do nome da classe, pois ela sera usada apenas uma vez.
		// Desta forma, declaramos a partir da interface Consumer<>
		nomes.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		System.out.println();
		System.out.println("2 - Após ordenada usando a função nomes.sort que recebe um objeto Comparator que ordena por ordem alfabética, ela fica assim:");
		
		// Ordenando por ordem alfabetica usando uma classe anonima de Comparator. Da mesma forma que na classe anonima de Consumer<>, damos new direto no Comparator<>.
		nomes.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		
		// Classe anonima de Consumer.
		nomes.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		System.out.println();
		System.out.println("3 - Ordenada por tamanho de nome, ela fica assim:");
		
		// Classe anonima de Comparator, utilizando o tamanho das strings como criterio de ordenacao.
		nomes.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		// Classe anonima de Consumer.
		nomes.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
	}
}