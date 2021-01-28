import java.util.Comparator;

public class ComparadorDePrecos implements Comparator<Produto> {

		@Override
		public int compare(Produto o1, Produto o2) {
			return Double.compare(o1.getPreco(), o2.getPreco());			
		}
		
	}