import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FDates {
	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje é " + hoje);

		// Sempre pega ano atual + 1
		int anoDoProximoAniversario = LocalDate.now().plusYears(1).getYear();

		// A classe Month possui todos os meses como constantes
		LocalDate proximoAniversario = LocalDate.of(anoDoProximoAniversario, Month.FEBRUARY, 2);
		System.out.println("Meu próximo aniversário é em " + proximoAniversario);

		// A classe Period eh usada para calcular periodos entre duas datas e a Duration para intervalo de horas
		Period periodo = Period.between(hoje, proximoAniversario);
		System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays());

		System.out.println();

		// A classe DateTimeFormatter eh usada para criar formatadores de datas a partir de padroes que nos definimos ou de constantes pre definidas
		System.out.println("Como formatar datas:");
		System.out.println("Hoje é " + hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Hoje é " + hoje.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")));
		System.out.println("Hoje é " + hoje.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));
		System.out.println("Hoje é " + hoje.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		System.out.println("Hoje é " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy, HH:mm")));
		
		// Convertendo de um LocalDate para um LocalDateTime
		LocalDate cyberpunk = LocalDate.of(2077, 1, 25);
		LocalDateTime.of(cyberpunk, LocalTime.now());
		
	}
}
