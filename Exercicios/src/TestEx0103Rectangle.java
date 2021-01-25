
public class TestEx0103Rectangle {

	public static void main(String[] args) {
		Ex0103Rectangle r1 = new Ex0103Rectangle(10f, 5f);
		
		System.out.println("Area = " + r1.getArea());
		System.out.println("Perimetro = " + r1.getPerimeter());
		
		// saida do toString
		System.out.println("saida do toString via chamada explicita: " + r1.toString());
		// ou ainda
		System.out.println("saida do toString via chamada implicita: " + r1);
		
	}
}
