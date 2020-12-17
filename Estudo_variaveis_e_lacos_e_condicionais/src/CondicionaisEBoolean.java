
public class CondicionaisEBoolean {
	public static void main(String[] args) {
		int idade = 4;
		int quantidadeDePessoas = 2;
		
		// Em Java o if, else e else if são feitos desta maneira:
		if (idade >= 18) {
			System.out.println("Seja bem vindo.");
		} else if (quantidadeDePessoas > 1) {
			System.out.println("Você é menor de idade, mas está acompanhado. Bem vindo.");
		} else {
			System.out.println("Você é menor de idade.");
		}
		
		// Podemos ainda resumir o código acima abstraindo os casos onde é permitida a entrada.
		// Em Java, or ou and é feito como || ou &&, respectivamente.
		if (idade >= 18 || quantidadeDePessoas > 1) {
			System.out.println("Bem vindo.");
		} else {
			System.out.println("Você é menor de idade.");
		}
		
		// Assim como em outras linguagens, Java interpreta expressões booleanas dentro do if, ou seja, podemos resumir as expressões a uma única variável:
		boolean entradaPermitida = (idade >= 18 || quantidadeDePessoas > 1);
		
		if (entradaPermitida) {
			System.out.println("Bem vindo.");
		} else {
			System.out.println("Você é menor de idade.");
		}
	}
}
