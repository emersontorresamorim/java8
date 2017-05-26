package br.com.alura.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		//************************************************************//
		// APENAS DATA
		LocalDate hoje = LocalDate.now();
		LocalDate futuro = LocalDate.of(2019, Month.JUNE, 5);
		
		Period periodo = Period.between(hoje, futuro);
		System.out.println(periodo);
		
		System.out.println(futuro.plusYears(4));
		
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatadorData));
		
		//************************************************************//
		// DATA E HORA
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println(agora.format(formatadorDataHora));
		
		System.out.println("//************************************************************//");
		// APENAS HORA
		LocalTime horario = LocalTime.now();
		DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("hh:mm:ss.ms");
		System.out.println(horario.format(formatadorHora));
		
		//************************************************************//
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		LocalDate dataPresente = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		Period periodoEntreDatas = Period.between(dataPresente, dataFutura);
		System.out.println(periodoEntreDatas);
		
		LocalTime horarioAtual = LocalTime.now();
		LocalTime horarioFuturo = LocalTime.of(13, 43);
		Duration duracaoEntreHorarios = Duration.between(horarioAtual, horarioFuturo);
		System.out.println(duracaoEntreHorarios);
	}
	
}
