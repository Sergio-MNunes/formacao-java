import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteLambda {

	public static void main (String args[]) {
		
		Produto p1 = new Produto("chiclete", 0.50);
		Produto p2 = new Produto("toddynho", 5.90);
		Produto p3 = new Produto("agua", 1.99);
		Produto p4 = new Produto("coca cola", 8.99);
		
		List<Produto> lista = new ArrayList<Produto>();
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		
		Collections.sort(lista);
		
		lista.sort( (Produto prod1, Produto prod2) -> Double.compare(prod1.getPreco(), prod2.getPreco()) );		
		lista.forEach( (Produto prod1) -> System.out.println(prod1) );

	}
}