package entities;

public class Servicos {

	private String servico;
	
	private Double preco;
	
	private Integer duracao;
	
	
	public Servicos() {
		
	}


	public Servicos(String servico, Double preco, Integer duracao) {
		this.servico = servico;
		this.preco = preco;
		this.duracao = duracao;
	}


	public String getServico() {
		return servico;
	}


	public void setServico(String servico) {
		this.servico = servico;
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
		return "\n Serviço: " + servico + "\n Preço: R$" + preco + "\n Duração: " + duracao + " min \n";
	}
	
	
	
}
