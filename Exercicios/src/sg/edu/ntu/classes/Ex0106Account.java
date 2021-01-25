package sg.edu.ntu.classes;

public class Ex0106Account {

	private String id;
	private String name;
	private int balance;
	
	public Ex0106Account (String id, String name) {
		this.id = id;
		this.name = name;
		this.balance = 0;
	}
	
	public Ex0106Account (String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int credit(int amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public int debit(int amount) {
		
		boolean possessAmount = amount <= this.balance;
		
		if (possessAmount) {
			this.balance -= amount;
			return this.balance;
		}
		System.out.println("amount exceeded");
		return this.balance;
	}
	
	public int transferTo(Ex0106Account another, int amount) {
		
		boolean possessAmount = amount <= this.balance;
		
		if (possessAmount) {
			this.balance -= amount;
			another.balance += amount;
			return this.balance;
		}
		System.out.println("amount exceeded");
		return this.balance;
	}
	
	@Override
	public String toString() {
		return "Account[id=" + this.id + ",name=" + this.name + ",balance=" + this.balance + ']';
	}
	
	
}