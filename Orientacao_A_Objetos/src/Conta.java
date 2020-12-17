public class Conta {
	int agencia;
	int numero;
	double saldo;
	Cliente titular; // desta maneira podemos associar um objeto a outro. Neste caso, estamos associando a classe Conta à classe Cliente. Toda conta tem um cliente.
	
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
}