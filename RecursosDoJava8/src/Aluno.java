
public class Aluno {
	private String nome;
	private int idade;
	
	public Aluno (String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", idade: " + this.idade + "]";
	}
}
