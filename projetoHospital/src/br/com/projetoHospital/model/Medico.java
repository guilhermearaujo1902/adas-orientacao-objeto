package br.com.projetoHospital.model;

import java.util.ArrayList;
import java.util.List;

public class Medico {

	private int id;
	private String nome;
	private String especializade;
	private boolean isPlantao;
	private List<Paciente> pacientes;

	public Medico() {
		this.pacientes = new ArrayList<Paciente>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecializade() {
		return especializade;
	}

	public void setEspecializade(String especializade) {
		this.especializade = especializade;
	}

	public boolean isPlantao() {
		return isPlantao;
	}

	public void setPlantao(boolean isPlantao) {
		this.isPlantao = isPlantao;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	private List<Paciente> getPacientesInternados() {
		List<Paciente> lista = new ArrayList<Paciente>();
		for (Paciente paciente : this.pacientes) {
			if (paciente.isInternado()) {
				lista.add(paciente);
			}
		}
		return lista;
	}

	public void cadastrarPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
		System.out.println("\nPaciente cadastrado com sucesso!");
	}

	public void imprimirRelatorioPacientes(int tipoRelatorio) {

		if (this.pacientes.size() == 0) {
			System.out.println("Sem pacientes cadastrados.");
		} else {
			// Tipos de Relatórios:
			// 1 - Imprimir todos
			// 2 - Imprimir Internados
			// 3 - Imprimir Não Internados
			switch (tipoRelatorio) {
			case 1:
				System.out.println("\n\n- Relatório de Pacientes: dr(a) " + this.nome + " -");
				for (Paciente paciente : this.pacientes) {
					paciente.exibirDadosPaciente();
				}
				break;
			case 2:

				List<Paciente> internados = getPacientesInternados();

				if (internados.size() == 0) {
					System.out.println("Não existem pacientes internados.");
				} else {
					System.out.println("\n\n- Relatório de Pacientes Internados: dr(a) " + this.nome + " -");
					for (Paciente paciente : internados) {
						paciente.exibirDadosPaciente();
					}
				}

				break;
			case 3:
				System.out.println("\n\n- Relatório de Pacientes não Internados: dr(a) " + this.nome + " -");
				for (Paciente paciente : this.pacientes) {
					if (paciente.isInternado() == false) {
						paciente.exibirDadosPaciente();
					}
				}
				break;
			default:
				System.out.println("Tipo de relatório indisponível.");
			}
		}
	}

	/*
	 * Desobrir qual paciente receberá alta Descobrir se o paciente está internado
	 * ou não Atualizar a propriedade que indica a internação
	 */
//	Abordagem 1
//	public void realizarAltaPaciente(Paciente paciente) {
//		if (paciente.isInternado() == true) {
//			paciente.setIsInternado(false);
//			System.out.println(paciente.getNome() + " está de alta!");
//		}
//	}
	public void realizarAltaPaciente(int idPaciente) {

		Paciente pacienteAlta = null;

		for (Paciente paciente : this.pacientes) {
			if (paciente.getId() == idPaciente) {
				pacienteAlta = paciente;
			}
		}

		if (pacienteAlta == null) {
			System.out.println("Paciente não encontrado para o id: " + idPaciente);
		} else {
			if (pacienteAlta.isInternado() == true) {
				pacienteAlta.setIsInternado(false);
				System.out.println(pacienteAlta.getNome() + " está de alta!");
			} else {
				System.out.println(pacienteAlta.getNome() + " não está internado!");
			}
		}

	}

}
