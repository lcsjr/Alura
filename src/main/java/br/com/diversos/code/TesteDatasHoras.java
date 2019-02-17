package br.com.diversos.code;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.apache.axis.types.Day;

public class TesteDatasHoras {

	public static void main(String[] args) {

		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
			
		LocalDateTime diaHora = LocalDateTime.now();
		System.out.println("--------------------------------------------------------------");
		System.out.println("	Data e Hora atual: " + diaHora.format(formatDateTime) +"\n" );
		System.out.println("Data: "+diaHora.toLocalDate().format(formatDate) );
		System.out.println("Hora: "+diaHora.toLocalTime().format(formatTime) );
		System.out.println("--------------------------------------------------------------\n\n");
		

		// TRABALHANDO COM DATAS
		LocalDate hoje = LocalDate.now();
		System.out.print("Hoje é dia " + hoje.format(formatDate));
		System.out.println(", e amanhã será " + hoje.plusDays(1).format(formatDate) +" \n");

		LocalDate aniversarioDavi = LocalDate.of(2019, Month.FEBRUARY, 20);
		Period dias = Period.between(hoje, aniversarioDavi);
		System.out.print("O aniversario do Davi é " + aniversarioDavi.format(formatDate));
		System.out.println(", e faltam " + dias.getDays() + " dias para a festa." + System.lineSeparator());
		
		System.out.println(YearMonth.now() + " Ou somente o ano " + Year.now());
		System.out.println();
		
		LocalTime horaInicio = LocalTime.of(18, 30);
		LocalTime horaTermino = LocalTime.of(22, 30);
		System.out.println("O curso de PLSQL inicia as " + horaInicio + " e termina por volta das " + horaTermino);
		
		
	}

}
