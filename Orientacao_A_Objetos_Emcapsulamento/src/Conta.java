public class Conta {
	private int agencia;
	private int numero;
	private double saldo;
	private Cliente titular;
	private static long totalDeContasAbertas; // Este é um atributo estático, ou seja, um atributo da classe Conta, e não de seus objetos.
	
	// Este é o construtor. Esquivalente ao def __init__(self, ...): do python
	// O construtor basicamente serve para obrigarmos quem usa nossa classe a passar parâmetros na instanciação do objeto, assim,
	// conseguimos manter um padrão entre todos os objetos, criados seguindo regras de negócio.
	public Conta(int agencia, int numero) { // Construtor padrão
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("Criando a conta " + this.agencia + " " + this.numero);
		Conta.totalDeContasAbertas++;
	}
	
	// Podemos inclusive criar mais de um construtor por classe. Desta forma, podemos definir valores padrão para atributos não informados.
	// Repare que utilizamos aqui o this como se ele fosse um método. Quando utilizamos o this desta forma, ele chama o construtor do objeto,
	// Assim, podemos definir valores padrão para os atributos obrigatórios.
	public Conta(int numero) { // Construtor complementar (define valores padrão para atributos obrigatórios)
		this(0001, numero);
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean transfere(double valor, Conta contaDestino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			contaDestino.saldo += valor;
			return true;
		}
		return false;
	}
	
	// para trabalhar com atributos privados, precisamos utilizar os métodos getters e setters. Chamamos isso de interface do objeto, é a maneira correta de interagir com eles.
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Número de agência não pode ser menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Número de conta não pode ser menor ou igual a 0");
		}
		this.numero = numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	// Este é um método estático, ou seja, um método da classe Conta, e não de seus objetos. Não precisamos ter nenhum objeto instanciado para utilizar métodos estáticos.
	public static long getTotalDeContasAbertas() {
		return Conta.totalDeContasAbertas;
	}
}