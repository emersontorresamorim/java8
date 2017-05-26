package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("Editora Casa do C�digo");
		palavras.add("Caelum");
		palavras.add("Alura Online");

		// NO JAVA 7 ERA NECESS�RIO USAR A CLASSE UTILIT�RIA COLLECTIONS COM
		// M�TODO SORT EST�TICO
		// Collections.sort(palavras, comparadorPorTamanho);

		// NO JAVA 8 EXISTEM DEFAULT METHODS, QUE S�O M�TODOS CONCRETOS
		// DEFINIDOS EM INTERFACES, PERMITINDO EVOLU��O DE UMA INTERFACE
		// SEM QUEBRAR AS CLASSES QUE A IMPLEMENTAM (ADICIONAR PALAVRA-CHAVE
		// DEFAULT NA ASSINATURA DO M�TODO)
		// palavras.sort((String s1, String s2) -> s1.length() - s2.length());
		
		// UM JEITO AINDA MAIS F�CIL DE FAZER A ORDENA��O � USAR A FACTORY DE COMPARATOR,
		// ATRAV�S DO M�TODO EST�TICO COMPARING DA INTERFACE FUNCIONAL COMPARATOR,
		// QUE RECEBE UM PAR�METRO DO TIPO FUNCTION, ACEITANDO LAMBDA OU METHOD REFERENCE
		// DESTAQUE PARA SEM�NTICA DO C�DIGO, QUE FICA DE F�CIL LEITURA E ENTENDIMENTO
		palavras.sort(Comparator.comparing(s -> s.length())); 
		palavras.sort(Comparator.comparing(String::length));
		System.out.println(palavras);

		// NO JAVA 7 O FOREACH ERA UM LA�O NO FORMATO ABAIXO
		// for (String p : palavras) {
		// 		System.out.println(p);
		// }

		// NO JAVA 8 COM INTERFACES FUNCIONAIS E LAMBDA � POSS�VEL FAZER COMO ABAIXO
		palavras.forEach(s -> System.out.println(s));
		
		// NO JAVA 8 COM INTERFACES FUNCIONAIS E METHOD REFERENCE � POSS�VEL FAZER COMO ABAIXO
		palavras.forEach(System.out::println);
		
		// USANDO LAMBA COM THREAD
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}
