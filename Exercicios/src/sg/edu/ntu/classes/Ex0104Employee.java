package sg.edu.ntu.classes;

public class Ex0104Employee {

	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	public Ex0104Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return this.firstName + ' ' + this.lastName;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAnnualSalary(){
		return this.salary*12;
	}
	
	public int raiseSalary(double percent) {
		this.salary += this.salary*(percent/100);
		return this.salary;
	}
	
	public String toString() {
		return "Employee[id=" + this.id + ",name=" + this.getName() + ",salary=" + this.salary + ']';
	}
}
