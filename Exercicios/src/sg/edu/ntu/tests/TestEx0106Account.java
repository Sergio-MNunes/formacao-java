package sg.edu.ntu.tests;
import sg.edu.ntu.classes.Ex0106Account;

public class TestEx0106Account {

	public static void main (String[] args) {
		Ex0106Account c1 = new Ex0106Account("01", "Sergio", 500);
		Ex0106Account c2 = new Ex0106Account("02", "Thainan", 100);
		
		System.out.println("Saldo inicial de c1: " + c1.getBalance());
		System.out.println("Saldo inicial de c2: " + c2.getBalance());
		
		c1.credit(50);
		System.out.println("1 - c1 apos credito de 50: " + c1.getBalance());
		
		c1.debit(250);
		System.out.println("2 - c1 apos debito de 250: " + c1.getBalance());
		
		c1.transferTo(c2, 200);
		System.out.println("3 - saldo da c1 apos transferencia de 200: " + c1.getBalance() + "\n    saldo da c2 apos transferencia de 200: " + c2.getBalance());
	}
}