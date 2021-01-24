public class TestaInterface {
	public static void main(String[] args) {
		Conta conta = new Conta();
		CalculadoraDeImpostos cdi = new CalculadoraDeImpostos();
		
		conta.deposita(100);
		cdi.calcula(conta);
		cdi.getTotal();
	}
}
