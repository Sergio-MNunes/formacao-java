
public class TestaPooEncapsulada {
	public static void main(String[] args) {
	
		Cliente sergio = new Cliente();
		Conta conta = new Conta(1234, 123445678);
		Conta conta2 = new Conta(634523477); // Esta conta está sendo criada com o construtor complementar, que não exige uma agência. Neste caso, é utilizada a agência padrão 0001
		Conta conta3 = new Conta(3456, 123468987);
		conta.deposita(300);
		conta.setTitular(sergio); // nada demais, apenas passamos a referência para o setter do objeto conta, assim como os outros atributos acima.
		System.out.println(conta.getAgencia());
		
		// Utiliza o método estático (método da própria classe, e não de algum objeto)
		System.out.println("O total de contas criadas com a nossa classe, até o momento, é " + Conta.getTotalDeContasAbertas());
		
		// para trabalhar com getters e setters de referências dentro do nosso objeto, utilizamos o getter do objeto e, em seguida, utilizamos os getters/setters da referência
		conta.getTitular().setNome("Sergio de Magalhaes Nunes");
		
		System.out.println(conta.getTitular().getNome());
	
		// é confuso, mas basicamente estamos fazendo isso:
		Cliente outraReferenciaAoSergio = conta.getTitular();
		System.out.println(outraReferenciaAoSergio.getNome());
		
		// olhe o endereço de memória das nossas referências, é tudo igual:
		System.out.println(sergio);
		System.out.println(conta.getTitular());
		System.out.println(outraReferenciaAoSergio);
		// primeiro, criamos o objeto Cliente e colocamos sua referência na variável sergio;
		// depois, atribuímos essa referência ao atribulo "titular" do objeto conta através do conta.setTitular(sergio);
		// depois, atribuímos essa mesma referência à nova variável (nova REFERÊNCIA, e não novo OBJETO) "outraReferenciaAoSergio";
		// portanto, sergio = conta.getTitular() = outraReferenciaAoSergio;
		
	}
}
