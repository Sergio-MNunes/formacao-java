import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Os Methods References sao uma alternativa mais sucinta ainda aos lambdas, mas eles so podem ser utilizados quando queremos passar um argumento e invocar um metodo,
// portanto, seu uso eh mais restrito que o dos lambdas.

// Os lambdas, pensando pragmaticamente, nada mais sao do que uma maneira de dizer que, dados os argumentos xyz, queremos invocar o metodo abc, por exemplo
// nomes.sort((s1, s2) -> s1.compareTo(s2)). Dados os argumentos s1 e s2, quero invocar o metodo compareTo() do s1, passando s2 como argumento do metodo,
// e essa inclusive eh a maneira de se ler uma lambda expression.

// Dito tudo isso a respeito do lambda, fica mais facil compreender as methods references, porque eles sao lidos da mesma maneira, mas possuem a restricao
// de aceitar apenas um argumento.

// PS: o metodo invocado tanto pelo lambda quanto pelo method reference nao precisa necessariamente ser do argumento passado a eles. Pode ser qualquer metodo.
// Vemos um exemplo disso com o lambda que utiliza System.out.println() para um dado argumento que eh uma String. o metodo println() nao eh da classe String,
// mas a lambda expression funciona mesmo assim. O mesmo vale para method reference.

// O codigo abaixo converte todas as funcoes lambdas do programa C para methods references **quando eh possivel fazer a conversao**

public class DMethodReference {
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();

		nomes.add("Sergio de Magalhaes Nunes");
		nomes.add("Paulo Henrique Hirata Nunes");
		nomes.add("Lucas Bruno Bezerra");
		nomes.add("Thainan Fuza de Oliveira");
		nomes.add("Bruno Fernando Correa de Abreu");
		nomes.add("Elisangela de Magalhaes");

		System.out.println("1 - A ordem de inserção da nossa lista é:");

		// A lambda expression do passo 1 do codigo C pode ser convertida, pois dado 1 argumento (String s), ela invoca o metodo println()
		// Convertido fica desse jeito.
		nomes.forEach(System.out::println);
		// Dado um argumento (elemento da lista nomes), invoca o metodo println de System.out

		System.out.println();
		System.out.println("2 - Após ordenada usando a função nomes.sort que recebe um objeto Comparator que ordena por ordem alfabética, ela fica assim:");

		// Esta lambda expression NAO PODE ser convertida para method reference, pois recebe dois argumentos (s1 e s2)
		nomes.sort((s1, s2) -> s1.compareTo(s2));

		nomes.forEach(System.out::println);

		System.out.println();
		System.out.println("3 - Ordenada por tamanho de nome, ela fica assim:");

		// A lambda expression do passo 3 do programa C tambem NAO PODE ser convertida para method reference, pois ela recebe dois argumentos (s1 e s2).
		// Porem, podemos utilizar um metodo default e abstrato da interface Comparator para nos ajudar. O metodo comparing recebe como argumento
		// uma Interface Funcional chamada Function, portanto, podemos substitui-la pela lambda expression abaixo
		nomes.sort(Comparator.comparing(s -> s.length()));
		// O metodo comparing transforma a Interface Funcional Function recebida como argumento em um Comparator. Em outras palavras, o metodo comparing
		// transforma a lambda expression em um comparator, utilizando o metodo que a lambda expression chama como criterio de comparacao.
		
		// Voce reparou no que fizemos acima? Com a ajuda do metodo default abstrato Comparator.comparing(), transformamos uma lambda expression que antes usava dois argumentos
		// (s1 e s2) em uma lambda expression que agora recebe apenas um argumento (String s) e, dado este argumento, chama o metodo length do proprio argumento.
		// Se a lambda expression recebe um argumento e chama um metodo, podemos utilizar o method reference em seu lugar. Ficaria assim:
		nomes.sort(Comparator.comparing(String::length));

		// Classe anonima de Consumer.
		nomes.forEach(System.out::println);
	}
}
