package br.com.meuprojeto.classes;

public class Aluno {
	private String nome;
	private int matricula;

	public Aluno(String nome, int matricula) {
		if (nome == null) {
			throw new NullPointerException("O nome do aluno nao pode ser null");
		}
		
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", matricula: " + this.matricula + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		return this.nome.equals(outroAluno.nome);
	}
	
	@Override
	public int hashCode() {
		// Os sets utilizam o hashCode dos objetos para aplicar as suas operacoes de forma mais performatica do que as listas (tabela de espalhamento).
		// Resumindo, os sets separam os objetos contidos neles em grupos de hashcodes, e quando perguntamos ao set se ele contem um objeto igual ao que estamos passando,
		// o set olha o hashCode do objeto recebido como parametro, e olha apenas os hashCodes dos objetos contidos nele. Se encontrar algum grupo com o mesmo hashCode, 
		// ele olha apenas para esse grupo. Isso economiza tempo, pois nao eh preciso comparar todos os objetos com o que foi recebido para saber se tem algum igual ou nao.
		
		return this.nome.hashCode();
				
		// Podemos definir a regra que quisermos para atribuir um hashCode a um objeto Aluno, como por exemplo a linha "return this.nome.charAt(0);" que usaria o primeiro
		// caracter do nome para definir o hashCode. Mas a classe String ja possui o metodo hashCode() utilizado para definir o hashCode de acordo com a String de forma mais
		// confiavel.
	}
}
