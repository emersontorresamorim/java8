package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("Editora Casa do Código");
		palavras.add("Caelum");
		palavras.add("Alura Online");

		// NO JAVA 7 ERA NECESSÁRIO USAR A CLASSE UTILITÁRIA COLLECTIONS COM
		// MÉTODO SORT ESTÁTICO
		// Collections.sort(palavras, comparadorPorTamanho);

		// NO JAVA 8 EXISTEM DEFAULT METHODS, QUE SÃO MÉTODOS CONCRETOS
		// DEFINIDOS EM INTERFACES, PERMITINDO EVOLUÇÃO DE UMA INTERFACE
		// SEM QUEBRAR AS CLASSES QUE A IMPLEMENTAM (ADICIONAR PALAVRA-CHAVE
		// DEFAULT NA ASSINATURA DO MÉTODO)
		// palavras.sort((String s1, String s2) -> s1.length() - s2.length());
		
		// UM JEITO AINDA MAIS FÁCIL DE FAZER A ORDENAÇÃO É USAR A FACTORY DE COMPARATOR,
		// ATRAVÉS DO MÉTODO ESTÁTICO COMPARING DA INTERFACE FUNCIONAL COMPARATOR,
		// QUE RECEBE UM PARÂMETRO DO TIPO FUNCTION, ACEITANDO LAMBDA OU METHOD REFERENCE
		// DESTAQUE PARA SEMÂNTICA DO CÓDIGO, QUE FICA DE FÁCIL LEITURA E ENTENDIMENTO
		palavras.sort(Comparator.comparing(s -> s.length())); 
		palavras.sort(Comparator.comparing(String::length));
		System.out.println(palavras);

		// NO JAVA 7 O FOREACH ERA UM LAÇO NO FORMATO ABAIXO
		// for (String p : palavras) {
		// 		System.out.println(p);
		// }

		// NO JAVA 8 COM INTERFACES FUNCIONAIS E LAMBDA É POSSÍVEL FAZER COMO ABAIXO
		palavras.forEach(s -> System.out.println(s));
		
		// NO JAVA 8 COM INTERFACES FUNCIONAIS E METHOD REFERENCE É POSSÍVEL FAZER COMO ABAIXO
		palavras.forEach(System.out::println);
		
		// USANDO LAMBA COM THREAD
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}
