package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Agendamento;
import entities.Cliente;
import entities.Profissional;
import entities.Servicos;

public class Program {

	private static String horaInicio = "10:00";
	private static String horaFim = "20:00";
	private static String horarioFinalDeServico = "";
	private static Double valoTotalDoServico = 0.0;
	private static String[] listaFuncionario = { "Alexandre", "Rodrigo", "Lucas" };
	private static List<Servicos> listaServicos = new ArrayList<>();

	private static List<String> horaSalao = new ArrayList<>();

	public static void main(String[] args) {
		
		

		Agendamento agendamento = new Agendamento();
		listaHorariosDoSalao(horaInicio, horaFim);
		Servicos servico = new Servicos();
		
		
		servico = new Servicos("Corte",25.00,30);
		listaServicos.add(servico);
		
		servico = new Servicos("Luzes",40.00,60);
		listaServicos.add(servico);
		
		servico = new Servicos("Progressiva",65.00,90);
		listaServicos.add(servico);
	
			
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);

		System.out.println("Qual o seu nome?: ");
		String nome = sc.nextLine();
		cliente.setNome(nome);
		
		
		boolean contin = true;
		int duracaoMaxima = 0;
		
		int i = 0;		/*Escolher servico*/
		while (contin) {
			contin = false;

			System.out.println("Serviços disponiveis:");
			
			i=0;
			for (Servicos servic : listaServicos) {
				System.out.println("[ " + i + " ] " + servic.getServico());
				i++;
			}
			
			System.out.println();
			System.out.print("Escolha um serviço: ");
			int indexServico = sc.nextInt();
			
			agendamento.addServico(listaServicos.get(indexServico));
			duracaoMaxima += listaServicos.get(indexServico).getDuracao();
			valoTotalDoServico += listaServicos.get(indexServico).getPreco();
			
			System.out.println("Deseja adicionar outros serviços? (Y/N)");
			String decisao = sc.next();

			if (decisao.toUpperCase().equals("Y")) {
				contin = true;
			} else if (decisao.toUpperCase().equals("N")) {
				contin = false;
			}
		}/*Escolher servico*/
		

		System.out.println("Digite a data em que deseja fazer o seu agendamento");
		String dataAgendamento = sc.next();

		System.out.println("Profissionais disponiveis: ");
		i = 0;
		for (String profissionais : listaFuncionario) {
			System.out.println("[ " + i + " ] " + profissionais);
			i++;
		}
		System.out.println();
		System.out.print("Escolha um profissional: ");
		int indexProfissional = sc.nextInt();
		System.out.println();
		
		Profissional profissional = new Profissional();
		profissional.setNome(listaFuncionario[indexProfissional]);
		

		System.out.println("Horarios disponiveis para agendar:");

		boolean result = true;
		String horaIni = "";
		
		while (result) {

			i = 0;
			
			for (String hora : horaSalao) {
				System.out.println("[ " + i + " ] " + hora);
				i++;
			}
			
			System.out.print("Escolha um horario: ");
			int indexHorario = sc.nextInt();

			horaIni = horaSalao.get(indexHorario);
			
			result = validarHorario(horaIni, duracaoMaxima);
			
			
			if (result) {
				removerHorariosDoSalao(horaIni, duracaoMaxima);
				System.out.println("Horarios disponivel");
				result = false;
			} else {
				System.out.println("Horarios não disponivel escolha outro horario");
				result = true;
			}						
		}
		agendamento.setCliente(cliente);
		agendamento.setProfissional(profissional);
		agendamento.setData(dataAgendamento);
		agendamento.setHoraInicio(horaIni);
		agendamento.setHoraTermino(horarioFinalDeServico);
		agendamento.setValorTotal(valoTotalDoServico);
		
		System.out.println(agendamento);
		sc.close();

	}

	/*
	 * Criar uma validação de horas por exemplo se eu marcar as 12h e de 12:30 até
	 * as 14 horas já estiver ocupado
	 */
	public static boolean validarHorario(String horaIni, Integer duracao) {

		String[] inicio = horaIni.split(":");
		
		
		if (duracao != 0) {

			if (horaSalao.indexOf(horaIni) != -1) {
				int zero = Integer.parseInt(inicio[0]);
				int um = Integer.parseInt(inicio[1]);
				
				if (um == 30) {
					horaIni = (zero + 1) + ":00";		
				} else{
					horaIni = zero + ":30";
				}	
				
				duracao -= 30;
				horarioFinalDeServico = horaIni;
				Program.validarHorario(horaIni, duracao);
			} else {
				
				return false;
			}

		} else {
			
			return false;
		}
		
			return true;
		
	}

	public static void removerHorariosDoSalao(String horaIni, Integer duracao) {

		if (duracao == 0) {
			return;
		}

		String[] inicio = horaIni.split(":");
		String newHorario = horaIni;
		if (horaSalao.indexOf(horaIni) != -1) {
			horaSalao.remove(horaIni);

		}
		int zero = Integer.parseInt(inicio[0]);
		int um = Integer.parseInt(inicio[1]);

		if (um == 30) {
			newHorario = (zero + 1) + ":00";
		} else if (um == 0) {
			newHorario = zero + ":30";
		}

		duracao -= 30;
		removerHorariosDoSalao(newHorario, duracao);

	}

	public static void listaHorariosDoSalao(String horaIni, String horaFim) {

		String[] inicio = horaIni.split(":");

		if (inicio[0].equals("20") && inicio[1].equals("00")) {
			return;
		}

		if (Integer.parseInt(inicio[1]) <= 60) {

			int zero = Integer.parseInt(inicio[0]);
			int um = Integer.parseInt(inicio[1]);

			if (um == 60) {
				zero++;
				horaSalao.add(zero + ":00");
				listaHorariosDoSalao(zero + ":00", horaFim);

			} else if (um == 30) {
				horaSalao.add(horaIni);
				listaHorariosDoSalao(zero + ":" + (um + 30), horaFim);
			} else {

				if (horaSalao.indexOf(horaIni) == -1) {
					horaSalao.add(horaIni);
				}

				listaHorariosDoSalao(zero + ":" + (um + 30), horaFim);
			}

		}

	}

}
