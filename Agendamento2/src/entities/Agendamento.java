package entities;

import java.util.ArrayList;
import java.util.List;

public class Agendamento {
	
	private Cliente cliente;
	
	private Profissional profissional;
	
	private String data;
	
	private String horaInicio;
	
	private String horaTermino;
	
	private List<Servicos> listaServicos = new ArrayList<>();
	
	private Double valorTotal;
	
	
	public Agendamento() {
		
	}


	public Agendamento(Cliente cliente, Profissional profissional, String data, String horaInicio, String horaTermino,Double valorTotal) {
		this.cliente = cliente;
		this.profissional = profissional;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.valorTotal = valorTotal;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Profissional getProfissional() {
		return profissional;
	}


	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraTermino() {
		return horaTermino;
	}


	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	

	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public void addServico(Servicos servico) {
		this.listaServicos.add(servico);
	}
	
	
	public List<Servicos> getListaServicos() {
		return listaServicos;
	}

	@Override
	public String toString() {
		return "Agendamento:\n cliente: " + cliente.getNome() + "\n Profissional: " + profissional.getNome() + "\n Data: " + data + "\n Horario de entrada: "
				+ horaInicio + "\n Horario de saida: " + horaTermino + "\n Servicos: \n \n" + listaServicos + " \n Valor total do serviço: R$" + valorTotal;
	}
	
	
	
	
}
