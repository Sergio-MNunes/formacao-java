import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

// Adicionar novos metodos nas interfaces era algo problematico ate o Java 7, pois por definicao, uma interface obriga todas as classes que a contratam a 
// implementar os seus metodos. Isso seria um grande problema, pois a essa altura ja existem inumeras classes que implementam as interfaces, 
// e adicionar um novo metodo numa interface implicaria em modificar todas essas classes que a contratam.

// Pensando nisso, no Java 8 foram introduzidos os Defaults Methods. Eles possuem sua implementacao dentro da propria declaracao da interface,
// algo que nao era possivel ate entao (as interfaces, por definicao, possuiam apenas a assinatura dos metodos. A implementacao ficava por conta de quem a contratava).
// Assim, poderiam ser adicionados novos metodos nas interfaces sem a necessidade de alterar as classes que a contratavam. Todas as classes que contratam uma interface
// que possui um default method automaticamente possui aquele default method tambem. o metodo sort() e o metodo forEach() sao dois exemplos de default methods,
// mas existem varios outros. Para declarar um default method, basta adicionar a palavra "default" em sua assinatura:

// default void sort(Comparator<? super E> c) {

public class ADefaultMethods {
	public static void main(String[] args) {

		List<String> nomes = new ArrayList<>();

		nomes.add("Sergio de Magalhaes Nunes");
		nomes.add("Paulo Henrique Hirata Nunes");
		nomes.add("Lucas Bruno Bezerra");
		nomes.add("Thainan Fuza de Oliveira");
		nomes.add("Bruno Fernando Correa de Abreu");
		nomes.add("Elisangela de Magalhaes");

		// No Java 7 ou anterior, era utilizado esta forma para imprimir uma lista.
		System.out.println("1 - A ordem de inserção da nossa lista é:");
		for (String nome : nomes) {
			System.out.println(nome);
		}
		
		System.out.println();
		System.out.println("2 - Após ordenada usando a função nomes.sort que recebe um objeto Comparator que ordena por ordem alfabética, ela fica assim:");
		
		// No Java 7 ou anterior, era utilizado a classe Collections para ordenar uma lista de acordo com a ordem natural de seus objetos ou com um Comparator recebido
		// como segundo parametro opcional.
		Collections.sort(nomes);

		// No java 8, foi introduzido o Default Method sort(Comparator<T>) na interface List, que descarta a necessidade de trabalhar com a classe Collections,
		// pois agora a propria lista possui o metodo sort.
		Comparator<String> comparaOrdemAlfabetica = new ComparaNomesOrdemAlfabetica();
		nomes.sort(comparaOrdemAlfabetica);
		
		// Da mesma forma que o metodo sort, o Java 8 tambem introduziu o default method forEach(Consumer<T>) na interface Iterable.
		// Assim, podemos substituir o for feito no passo 1 pelo metodo forEach() da lista
		Consumer<String> consumidorNomes = new ConsomeNomes();
		nomes.forEach(consumidorNomes);
		
		System.out.println();
		System.out.println("3 - Ordenada por tamanho de nome, ela fica assim:");
		
		// Podemos criar um novo Comparator, desta vez ordenando por tamanho da string por exemplo.
		// Repare que estamos usando os dois Default Methods da interface List e Iterable, sort() e forEach() respectivamente.
		Comparator<String> comparaTamanhoDosNomes = new ComparaNomesTamanho();
		nomes.sort(comparaTamanhoDosNomes);
		nomes.forEach(consumidorNomes);
	}
}

class ConsomeNomes implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}

class ComparaNomesOrdemAlfabetica implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}

class ComparaNomesTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return Integer.compare(s1.length(), s2.length());
	}
}