public class CalculadoraDeImpostos {

	double total = 0;

	public void calcula(PagarImposto ri) {
		this.total += ri.getImpostoAPagar();
	}

	public double getTotal() {
		System.out.println("O imposto a pagar é " + this.total);
		return this.total;
	}
}
