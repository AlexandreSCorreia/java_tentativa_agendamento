package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Agendamento;
import entities.Cliente;
import entities.Profissional;
import entities.Servicos;

public class Program {

	private static List<Servicos> listaServicos = new ArrayList<>();
	private static List<Profissional> listaFuncionarios = new ArrayList<>();
	private static List<Agendamento> listaAgendamentos = new ArrayList<>();
	private static List<String> horariosDisponiveis = new ArrayList<>();
	private static Integer duracao = 0;

	public static void main(String[] args) {

		
		/* Entrada de dados Inicio */
		
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
		Profissional profissional = new Profissional("Alex01", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		profissional = new Profissional("Alex02", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		profissional = new Profissional("Alex03", "10:00", "20:00");
		listaFuncionarios.add(profissional);
		// Fim adicionando profissional

		listarHorarios(profissional.getEntrada(), profissional.getSaida());
		
		
		
		/* Entrada de dados Fim */

		Scanner sc = new Scanner(System.in);

		String decisaoAgendamento = "Y";
		
		while (decisaoAgendamento.toUpperCase().equals("Y")) {
			Agendamento agendamento = new Agendamento();
			// Adicionando Cliente
			System.out.println("Escreva o seu nome: ");
			String nome = sc.next();
			Cliente cliente = new Cliente(nome);
			System.out.println();
			// Fim Adicionando Cliente

			// Adicionando Serviços
			String decisaoServico = "Y";
			while (decisaoServico.toUpperCase().equals("Y")) {
				System.out.println("Serviços Disponiveis:");
				int i = 0;
				for (Servicos service : listaServicos) {
					System.out.println("[" + i + "]" + service.getNome());
					i++;
				}
				System.out.println("Escolha um serviço: ");
				int indexServico = sc.nextInt();
				agendamento.addServico(listaServicos.get(indexServico));
				duracao += listaServicos.get(indexServico).getDuracao();
				System.out.println("Deseja adicionar outro servico? (Y/N) ");
				decisaoServico = sc.next();
			}
			System.out.println();
			// Fim Adicionando Serviços

			// Adicionando Profissional
			System.out.println("Profissionais Disponiveis");
			int i = 0;
			for (Profissional funcionario : listaFuncionarios) {
				System.out.println("[" + i + "]" + funcionario.getNome());
				i++;
			}
			System.out.println("Escolha um Profissional: ");
			int indexProfissional = sc.nextInt();
			System.out.println();
			// Fim Adicionando Profissional

			
			
			
			// Escolhendo Data
			System.out.println("Digite uma data para fazer o agendamento: ");
			String data = sc.next();
			// Fim Escolhendo Data

			// Escolhendo Horario
			System.out.println("Horarios Disponiveis:");
			i = 0;

			for (String hora : horariosDisponiveis) {

				if (listaAgendamentos != null && !listaAgendamentos.isEmpty()) {

					for (Agendamento agend : listaAgendamentos) {

						if (agend.validarHorario(hora, duracao)) {

							System.out.println("[" + i + "]" + hora);
							i++;
						}
						
					}

				} else {

					System.out.println("[" + i + "]" + hora);
					i++;
				}

			}

			System.out.println("Escolha um Horario: ");
			int indexHorarios = sc.nextInt();
			System.out.println(duracao);
			adicionarHorario(agendamento, horariosDisponiveis.get(indexHorarios), duracao);

			// Fim Escolhendo Horario

			// Mostrar Agendamento
			agendamento.setCliente(cliente);
			agendamento.setProfissional(listaFuncionarios.get(indexProfissional));
			agendamento.setData(data);
			listaAgendamentos.add(agendamento);
			System.out.println(listaAgendamentos);
			duracao = 0;
			System.out.println("Deseja fazer outro agendamento? (Y/N) ");
			decisaoAgendamento = sc.next();
		}

		sc.close();

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
