package br.com.projetoHospital.model;

import java.util.List;

public class Medico {
	
	private int id;
	private String nome;
	private String especializade;
	private boolean isPlantao;
	private List<Paciente> pacientes;
	
	public Medico () {
		
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
	
	
	public void cadastrarPaciente (Paciente paciente) {
		this.pacientes.add(paciente);
		System.out.println("\nPaciente cadastrado com sucesso!");
	}
	
	// Melhorar o método para que seja possível imprimir o relatório de 3 formas, sendo:
	// - todos os pacientes
	// - somente os pacientes internados
	// - somente os pacientes não internados
	public void imprimirRelatorioPacientes () {
		
		System.out.println("- Relatório de Pacientes: dr(a) " + this.nome + " -");
		for (Paciente paciente : this.pacientes) {
			paciente.exibirDadosPaciente();
		}
		
	}
	
	// Implementar o método 'realizarAltaPaciente'

}
