package br.com.meuprojeto.testes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestandoIteracaoEmMaps {

    public static void main(String[] args) {

        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
        System.out.println("As chaves contidas dentro do Map são " + pessoas.keySet());
        
        Set<Integer> chavesEncontradasNoMap = pessoas.keySet(); // O metodo keySet() retorna um Set contendo as chaves do Map.
        
        chavesEncontradasNoMap.forEach(chave -> {
        	System.out.println("Chave " + chave + ": " + pessoas.get(chave));
        });
        
		System.out.println(); // Podemos iterar assim tambem. A vantagem eh que nem precisamos criar um Set<Integer> intermediario
		pessoas.forEach((matricula, aluno) -> { // Para utilizar lambda partindo de dois parametros, fazemos desta forma (p1, p2) -> {}
			System.out.println("Chave " + matricula + ": " + aluno);
		});
    }
}