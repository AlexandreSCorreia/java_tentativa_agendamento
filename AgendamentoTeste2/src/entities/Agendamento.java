package entities;

import java.util.ArrayList;
import java.util.List;

public class Agendamento {

	private Cliente cliente;
	private List<Servicos> listaServico = new ArrayList<>();
	private Profissional profissional;
	private String data;
	private List<String> listaHorarios = new ArrayList<>();
	private boolean result = false;
	
	
	public Agendamento() {
	
	}

	public Agendamento(Cliente cliente, Profissional profissional, String data) {
		this.cliente = cliente;
		this.profissional = profissional;
		this.data = data;
	}
	
	public void result() {
		result =false;
	}
	
	public boolean validarHorario(String inicio, Integer tempo) {

		if (tempo != 0) {

			String[] entrada = inicio.split(":");
			int zero = Integer.parseInt(entrada[0]);
			int um = Integer.parseInt(entrada[1]);
			String novoHorario = "";

			if (listaHorarios.indexOf(inicio) == -1) {

				if (um == 60) {

					novoHorario = (zero + 1) + ":00";
					validarHorario(novoHorario, tempo - 30);
				} else {

					novoHorario = zero + ":" + (um + 30);
					validarHorario(novoHorario, tempo - 30);
				}				

			} else {
				
				result = false;
			}

		}
		
		if(tempo == 0) {
			result = true;
		}

		return result;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addServico(Servicos servico) {
		listaServico.add(servico);
	}
	
	public List<Servicos> getListaServico() {
		return listaServico;
	}
	
	public void addHora(String hora) {
		listaHorarios.add(hora);
	}
	
	public List<String> getListaHora() {
		return listaHorarios;
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

	@Override
	public String toString() {
		return "\n Agendamento: \nCliente: " + cliente.getNome() + "\n" + listaServico + "\n Profissional: " + profissional.getNome() + "\n Data:"
				+ data + "\n hora=" + listaHorarios + "\n";
	}	
}
