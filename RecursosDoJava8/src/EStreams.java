import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Conforme escrito na propria documentacao da interface Stream, ela pode ser vista como uma maneira de realizar queries em colecoes do Java.

public class EStreams {
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Sergio de Magalhaes Nunes", 26);
		Aluno a2 = new Aluno("Paulo Henrique Hirata Nunes", 12);
		Aluno a3 = new Aluno("Lucas Bruno Bezerra", 23);
		Aluno a4 = new Aluno("Thainan Fuza de Oliveira", 25);
		Aluno a5 = new Aluno("Bruno Fernando Correa de Abreu", 22);
		Aluno a6 = new Aluno("Elisangela de Magalhaes", 50);
		
		List<Aluno> alunos = new ArrayList<>();
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		alunos.add(a4);
		alunos.add(a5);
		alunos.add(a6);
		
		// Todas as colecoes do java possuem um metodo .stream(). Eh a partir dele que damos inicio as operacoes utilizando o stream, que usa a sintaxe abaixo,
		// chamando varios metodos cascateados. A stream abaixo filtra os alunos da lista que tem 25 anos ou mais e imprime eles
		System.out.println("1 - Printa alunos com 25 anos ou mais");
		alunos.stream()
			.filter(aluno -> aluno.getIdade() >= 25) // O metodo filter filtra os elementos da stream de acordo com o criterio passado como argumento
			.forEach(System.out::println);
		
		System.out.println();
		
		// Gera uma stream de alunos a partir da nossa lista e, a partir desta stream de alunos, gera uma nova stream de String com os nomes dos alunos.
		// Poderiamos fazer a mesma coisa utilizando a idade dos alunos, ou qualquer outro atributo. A interface Stream possui metodos de map especificos 
		// para alguns tipos primitivos tambem, como o mapToInt, mapToDouble ou o mapToFloat, que retornam uma IntMap, DoubleMap e FloatMap respectivamente.
		System.out.println("2 - Gera uma nova stream com os nomes dos alunos e printa essa nova stream");
		alunos.stream()
			.map(Aluno::getNome) // O metodo map retorna um stream com os elementos coletados conforme seu argumento (getNome no caso), ou seja, uma stream de nomes
			.forEach(aluno -> System.out.println(aluno));
		
		System.out.println();
		
		// Pega o aluno mais velho e printa
		System.out.println("3 - Printa o aluno mais velho da stream");
		alunos.stream()
			.max((aluno1, aluno2) -> Integer.compare(aluno1.getIdade(), aluno2.getIdade()))
			.ifPresent(System.out::println); // O metodo ifPresent pertence a uma classe chamada Optional. Esta classe serve para lidar com valores null, e por isso o 
											 // nome do metodo eh ifPresent(), porque o objeto de Optional nem sempre retorna com um valor do metodo que o devolve
		
		System.out.println();
		
		// Pega o aluno com o maior nome na stream e printa so o nome
		System.out.println("4 - Printa o aluno com o nome mais cumprido");
		alunos.stream()
			.max((aluno1, aluno2) -> Integer.compare(aluno1.getNome().length(), aluno2.getNome().length()))
			.ifPresent(a -> System.out.println(a.getNome()));
		
		System.out.println();
		
		// Printa a media de idade dos alunos na stream
		System.out.println("5 - Printa a media de idades dos alunos na stream");
		alunos.stream()
			.mapToInt(Aluno::getIdade)
			.average()
			.ifPresent(System.out::println);
		
		System.out.println();
		
		// Pega os alunos com 25 anos ou mais e cria uma nova lista contendo estes alunos
		System.out.println("6 - Cria uma nova lista, contendo alunos com 25 anos ou mais, e printa a lista");
		List<Aluno> alunosMaisVelhos = alunos.stream()
			.filter(a -> a.getIdade() >= 25)
			.collect(Collectors.toList());
	
		alunosMaisVelhos.forEach(System.out::println);
	}
}
