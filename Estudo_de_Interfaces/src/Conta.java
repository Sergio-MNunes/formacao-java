public class Conta implements PagarImposto {
	private double saldo;
	
	public double getImpostoAPagar() {
		return this.saldo * 0.02;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
}
