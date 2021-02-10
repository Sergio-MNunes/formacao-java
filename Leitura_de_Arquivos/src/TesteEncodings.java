import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TesteEncodings {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String nome = "Sérgio";
		
		System.out.println("A String é '" + nome + "'");
		
		System.out.println(nome.codePointAt(1)); // Pega o codepoint na posicao do index indicado, baseado no charset padrao do sistema
		
		byte[] codepoints = nome.getBytes("UTF-8"); // Converte a string para codepoints baseados no charset padrao do sistema, ou no charset passado como parametro
		
		System.out.print("A conversão dessa string para codepoints é "); 
		for(byte singleCodepoint : codepoints) {
			System.out.print(singleCodepoint + " "); // Repare como o byte que representa "é" fica incompreensível.
		}
		
		System.out.print(System.lineSeparator()); // System.lineSeparator() = System.out.println()
		
		String nomeConvertidoDoCodepoint = new String(codepoints, "UTF-8");
		System.out.println("A conversão desses codepoints para string é " + nomeConvertidoDoCodepoint);
		
		System.out.println("O charset (encoding) padrão deste computador é " + Charset.defaultCharset());
	}
}
