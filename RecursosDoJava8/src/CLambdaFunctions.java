import java.util.ArrayList;
import java.util.List;

// Os Default Methods resolveram o problema da manutencao nas interfaces do Java, mas criaram um problema de legibilidade no codigo, pois as classes anonimas
// costumam ser bastante verborragicas, ainda que nos poupem de precisar criar uma classe e instanciar um objeto para apenas usar uma interface que so possui um metodo.

// Estas interfaces que possuem apenas um metodo abstrato costumam ser chamadas de Interfaces Funcionais e o Java 8, alem dos default methods para as interfaces, introduziu uma
// forma mais amigavel de lidar com elas: as Lambda Expressions. 

// As Lambda Expressions nos ajudam a escrever as interfaces funcionais de maneira mais sucinta, pois o compilador esta preparado para interpreta-las como tais,
// ou seja, para escrevermos um lambda precisamos necessariamente estar lidando com uma interface funcional, esse eh basicamente o motivo da existencia delas.

// ****PRECISAMOS estar lidando com uma Interface Funcional para podermos utilizar uma lambda expression. Resumo abaixo:
//		- Uma interface que so possui um metodo abstrato eh chamada de Interface Funcional;
//		- Uma interface funcional pode ser trabalhada de tres maneiras: criando uma classe tradicional que a implementa, classes anonimas e lambdas;
// 		- A classe anonima tem a vantagem de nao se precisar criar uma classe e instanciar um objeto, pois isso tudo eh feito no momento de utilizar a interface funcional;
//		- A lambda eh uma alternativa muito mais agradavel as classes anonimas, pois elas costumam ser bastante verborragicas e as lambdas nao;


// O codigo abaixo eh uma versao do programa B, mas utilizando lambda no lugar das classes anonimas.
		

public class CLambdaFunctions {

	public static void main(String[] args) {
		
		List<String> nomes = new ArrayList<>();
		
		nomes.add("Sergio de Magalhaes Nunes");
		nomes.add("Paulo Henrique Hirata Nunes");
		nomes.add("Lucas Bruno Bezerra");
		nomes.add("Thainan Fuza de Oliveira");
		nomes.add("Bruno Fernando Correa de Abreu");
		nomes.add("Elisangela de Magalhaes");
		
		System.out.println("1 - A ordem de inserção da nossa lista é:");
		
		// Veja como a classe anonima da interface Consumer do passo 1 do programa B fica com Lambda (esta comentado so para nao imprimir a lista duas vezes na saida)
//		nomes.forEach((String s) -> {
//			System.out.println(s);
//		});
		
		// Podemos resumir a funcao lambda acima mais ainda! Como Consumer se trata de uma Interface Funcional e forEach recebe Consumer, o compilador ja consegue deduzir algumas 
		// coisas a respeito da classe anonima que seria utilizada:
		// 		- Consumer eh uma Interface Funcional, portanto podemos resumir a instanciacao do objeto para apena o parametro do metodo (entre parenteses caso seja mais de um).
		//		  O compilador ja deduz que se trata de argumentos para o metodo de Consumer, pois o metodo forEach recebe um Consumer e Consumer so possui um unico metodo.
		//		- Consumer funciona com generics <>, portanto o compilador presume que o metodo de Consumer trabalhara com o tipo dos objetos da lista que invoca o forEach
		//		  (String no caso). Desta forma, nao precisamos declarar o tipo do argumento passado para o lambda, pois ele deduz a partir da lista que o invocou.
		//		- Como nesse caso o lambda recebe apenas uma instrucao (sysout), o compilador nao exige que coloquemos as chaves e o ponto virgula no final da sentenca { ;}.
		
		// Levando tudo isso em conta, temos o nosso lambda mais enxuto ainda
		nomes.forEach(s -> System.out.println(s));
		
		System.out.println();
		System.out.println("2 - Após ordenada usando a função nomes.sort que recebe um objeto Comparator que ordena por ordem alfabética, ela fica assim:");
		
		// Veja como fica o sort do passo 2 do programa B utilizando lambda
		nomes.sort((String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		
		// E mais resumido ainda, com as suposicoes que o compilador eh capaz de fazer sabendo que ele esta lidando com a Interface Funcional Comparator.
		//		- Como a interface Comparator, utilizada pelo sort, possui apenas um metodo, o compilador ja deduz que estamos trabalhando com a saida deste metodo.
		//		  Portanto, nao precisamos colocar a palavra "return"
		//		- Ao contrario do forEach, o sort recebe dois argumentos, portanto precisamos coloca-los entre parenteses (s1, s2). Mas tambem nao precisamos 
		//		  declarar seus tipos. Poderiamos tambem usar lambda no caso de nao haver nenhum argumento, bastaria abrir e fechar parenteses () que a 
		//		  expressao tambem funcionaria sem problema nenhum
		nomes.sort((s1, s2) -> s1.compareTo(s2));
		
		// Lambda equivalente a classe anonima de Consumer do passo 2 do programa B.
		nomes.forEach(s -> System.out.println(s));
		
		System.out.println();
		System.out.println("3 - Ordenada por tamanho de nome, ela fica assim:");
		
		// funcao lambda utilizando o tamanho das strings como criterio de ordenacao.
		nomes.sort( (s1, s2) -> Integer.compare(s1.length(), s2.length()) );
		
		// Classe anonima de Consumer.
		nomes.forEach(s -> System.out.println(s));
	}
}