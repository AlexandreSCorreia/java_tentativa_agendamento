package application;

import java.util.ArrayList;
import java.util.List;

import entities.Agendamento;
import entities.Cliente;
import entities.Profissional;
import entities.Servicos;

public class Program {

	private static List<Servicos> listaServicos = new ArrayList<>();
	private static List<Profissional> listaFuncionarios = new ArrayList<>();
	private static List<Agendamento> listaAgendamentos = new ArrayList<>();
	private static List<String> horariosDisponiveis = new ArrayList<>();
	private static List<String> novosHorariosDisponiveis = new ArrayList<>();
	private static Integer duracao = 0;

	public static void main(String[] args) {

		// Adicionando Serviços
		Servicos servico = new Servicos();
		servico.setNome("Corte de Cabelo");
		servico.setPreco(25.00);
		servico.setDuracao(30);
		listaServicos.add(servico);

		servico = new Servicos("Luzes", 45.00, 60);
		listaServicos.add(servico);

		servico = new Servicos("Progressiva", 65.00, 90);
		listaServicos.add(servico);
		// Fim adicionando serviços

		// Adicionando Profissional
		Profissional profissional = new Profissional("Alexandre", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		profissional = new Profissional("Rodrigo", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		profissional = new Profissional("Lucas", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		// Fim adicionando profissional

		listarHorarios(profissional.getEntrada(), profissional.getSaida());

		Agendamento agendamento = new Agendamento();
		// Adicionando Cliente
		Cliente cliente = new Cliente("Bruna");
		// Fim Adicionando Cliente

		// Adicionando Serviços
		agendamento.addServico(listaServicos.get(1));
		duracao += listaServicos.get(1).getDuracao();
		// Fim Adicionando Serviços

		adicionarHorario(agendamento, horariosDisponiveis.get(1), duracao);
		System.out.println(horariosDisponiveis.get(1));
		// Fim Escolhendo Horario

		// Mostrar Agendamento
		agendamento.setCliente(cliente);
		agendamento.setProfissional(listaFuncionarios.get(0));
		agendamento.setData("09/04/2020");
		listaAgendamentos.add(agendamento);
		// System.out.println(listaAgendamentos);
		duracao = 0;

		agendamento = new Agendamento();
		// Adicionando Cliente
		cliente = new Cliente("Katerine");
		// Fim Adicionando Cliente

		// Adicionando Serviços
		agendamento.addServico(listaServicos.get(1));
		duracao += listaServicos.get(1).getDuracao();

		agendamento.addServico(listaServicos.get(2));
		duracao += listaServicos.get(2).getDuracao();

		// Fim Adicionando Serviços

		adicionarHorario(agendamento, horariosDisponiveis.get(5), duracao);
		System.out.println(horariosDisponiveis.get(5));
		// Fim Escolhendo Horario

		// Mostrar Agendamento
		agendamento.setCliente(cliente);
		agendamento.setProfissional(listaFuncionarios.get(0));
		agendamento.setData("09/04/2020");
		listaAgendamentos.add(agendamento);
		// System.out.println(listaAgendamentos);
		duracao = 0;
		
		
		

		agendamento = new Agendamento();
		// Adicionando Cliente
		cliente = new Cliente("Bryan");

		// Fim Adicionando Cliente

		// Adicionando Serviços
		agendamento.addServico(listaServicos.get(0));
		duracao += listaServicos.get(0).getDuracao();

		agendamento.addServico(listaServicos.get(1));
		duracao += listaServicos.get(1).getDuracao();

		// Fim Adicionando Serviços

		for (Agendamento agend : listaAgendamentos) {
			System.out.println();
			System.out.println("================================");
			List<String> list = agend.getListaHora();

			for (String hora : list) {
				
				if (listaAgendamentos.indexOf(hora) == -1 && novosHorariosDisponiveis.indexOf(hora) == -1) {
					novosHorariosDisponiveis.add(hora);
				}

			}

			System.out.println(novosHorariosDisponiveis);
			System.out.println("================================");
			System.out.println();
			
		}
		
		System.out.println("Listaaa");
		for(String hora : horariosDisponiveis) {

			if(novosHorariosDisponiveis.indexOf(hora) == -1 ||hora.equals( novosHorariosDisponiveis.get(novosHorariosDisponiveis.size() -1))) {
				System.out.println(hora);
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Lista 2");
		String[] utimoHorario = new String(horariosDisponiveis.get(horariosDisponiveis.size() -1)).split(":");
		for(String hora : horariosDisponiveis) {

			if(!hora.equals(utimoHorario[0]+":"+Integer.parseInt(utimoHorario[1])+ 30)) {
				
				if(novosHorariosDisponiveis.indexOf(hora) == -1 
						||hora.equals( novosHorariosDisponiveis.get(novosHorariosDisponiveis.size() -1))) {
					
					if(validarHorario(hora,duracao)) {
						
						System.out.println(hora);
					}
							
				}
			}
		}


		boolean result = validarHorario("10:00",duracao);
	
		if(result) {
			adicionarHorario(agendamento, horariosDisponiveis.get(0), duracao);
			// Mostrar Agendamento
			agendamento.setCliente(cliente);
			agendamento.setProfissional(listaFuncionarios.get(0));
			agendamento.setData("09/04/2020");
			listaAgendamentos.add(agendamento);
			System.out.println(listaAgendamentos);
			duracao = 0;

		}else {
			System.out.println("Horario não disponivel!!!");
		}

	}
	
	public static boolean validarHorario(String horario,Integer duracaoServico) {
		boolean isFree = false;
		boolean continuar = true;
		int tempo = duracaoServico;
		String novoHorario = "";
				
		String[] horarioAtual = new String(horario).split(":");
		
		while(continuar) {
			
			int zero = Integer.parseInt(horarioAtual[0]);
			int um = Integer.parseInt(horarioAtual[1]);
			if(tempo < 0) {
				continuar = false;
				 isFree = true;
				break;
			}			
			
		/*	if ( um != 60) {
				System.out.println(horarioAtual[0]+":"+horarioAtual[1]);
			}	*/	
			
			if(novosHorariosDisponiveis.indexOf(novoHorario) == -1) {
				
				if (um == 60) {

					novoHorario = (zero + 1) + ":00";
				
					horarioAtual = new String(novoHorario).split(":");
					tempo -=30;

				} else {

					novoHorario = zero + ":" + (um + 30);
					horarioAtual = new String(novoHorario).split(":");
					tempo -=30;
				}
				
			}else {
				continuar = false;
				
			}
			
		}
		
		return isFree;
	}

	public static void adicionarHorario(Agendamento agenmento, String inicio, Integer tempo) {

		if (!(tempo < 0)) {

			String[] entrada = inicio.split(":");

			int zero = Integer.parseInt(entrada[0]);
			int um = Integer.parseInt(entrada[1]);
			String novoHorario = "";

			if (agenmento.getListaHora().indexOf(inicio) == -1 && um != 60) {
				agenmento.addHora(inicio);
			}

			if (um == 60) {

				novoHorario = (zero + 1) + ":00";

			} else {

				novoHorario = zero + ":" + (um + 30);

			}

			adicionarHorario(agenmento, novoHorario, tempo - 30);
		}

	}

	public static void listarHorarios(String inicio, String fim) {
		String[] entrada = inicio.split(":");
		String[] saida = fim.split(":");

		int zero = Integer.parseInt(entrada[0]);
		int um = Integer.parseInt(entrada[1]);
		String novoHorario = "";

		if (horariosDisponiveis.indexOf(inicio) == -1 && um != 60) {
			horariosDisponiveis.add(inicio);
		}

		if (um == 60) {

			novoHorario = (zero + 1) + ":00";

		} else {

			novoHorario = zero + ":" + (um + 30);

		}

		if (entrada[0].equals(saida[0]) && entrada[1].equals(saida[1])) {
			return;
		}
		listarHorarios(novoHorario, fim);

	}

}
