package entities;

public class Profissional {

	private String nome;
	
	public Profissional() {
		
	}

	public Profissional(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Profissional [nome=" + nome + "]";
	}
	
	
}
