package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TesteCurso {

	public static void main(String[] args) {
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C#", 55));

		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));

		// FILTER: permite filtrar a stream retornando somente os que se encaixam nos critérios
		// MAP: permite obter uma stream a partir de uma function específica
		// SUM: método para somar valores de uma stream (quando se aplica, como uma IntStream)
		int totalAlunos = cursos.stream()
								.filter(c -> c.getAlunos() >= 100)
								.mapToInt(Curso::getAlunos)
								.sum();
		System.out.println("Total de Alunos de Cursos com mais de 100 matriculados: " + totalAlunos);
		
		// cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));
		// cursos.stream().map(Curso::getNome).forEach(System.out::println);
		
		cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .findAny()
			  .ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			  .filter(c -> c.getAlunos() >= 100)
			  .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
			  .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		cursos.stream()
			  .mapToInt(Curso::getAlunos)
			  .average()
			  .ifPresent(media -> System.out.println("Média de alunos em todos os cursos: " + media));
		
		
	}
}
