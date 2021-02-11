import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteEntradaESaida {

	public static void main (String[] args) throws IOException {
		
		InputStream fis = new FileInputStream("loren_ipsum.txt");
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		OutputStream fos = new FileOutputStream("loren_ipsum_de_saida.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		// le uma linha e armazena na variavel "linha"
		String linha = br.readLine(); 
		
		// imprime ate acabar o arquivo
//		while (linha != null){ 
//			System.out.println(linha);
//			linha = br.readLine();
//		}
		
		bw.write(br.readLine());
		
		br.close();
		bw.close();
	}
	
}
