package entities;

public class Profissional {

	private String nome;
	private String entrada;
	private String saida;
	
	public Profissional() {
		
	}

	public Profissional(String nome, String entrada, String saida) {
		this.nome = nome;
		this.entrada = entrada;
		this.saida = saida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Profissional \n Nome:" + nome + ", Horario de Entrada:" + entrada + ", Horario de Saida:" + saida + "\n";
	}
	
	
	
	
}
