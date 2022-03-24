package entities;

public class Servicos {

	private String servico;
	private Double preco;
	private Integer duracao;
	
	
	public Servicos() {
		
	}

	public Servicos(String nome, Double preco, Integer duracao) {
		this.servico = nome;
		this.preco = preco;
		this.duracao = duracao;
	}

	public String getNome() {
		return servico;
	}

	public void setNome(String nome) {
		this.servico = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "\n Serviços: \n Serviço: " + servico + "\n Preço: R$" + preco + "\n Duração=" + duracao + "min \n";
	}
	
	
	
}
