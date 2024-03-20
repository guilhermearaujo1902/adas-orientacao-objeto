package br.com.projetoHospital;

import br.com.projetoHospital.model.Medico;
import br.com.projetoHospital.model.Paciente;

public class Main {

	public static void main(String[] args) {

		// Instanciar 3 objetos da classe Paciente
		Paciente pac1 = new Paciente();
		pac1.setId(1);
		pac1.setNome("Jonas Brothers");
		pac1.setIdade(25);
		pac1.setSexo("Masculino");
		pac1.setIsInternado(true);
		
		Paciente pac2 = new Paciente(2, "Joana Dark", 77, "Feminino");
		pac2.setIsInternado(true);
		
		Paciente pac3 = new Paciente(3, "Laura", 20, "Feminino");
		pac3.setIsInternado(false);


		// Instanciar 1 objeto da classe Medico
		Medico medica = new Medico();
		medica.setId(1);
		medica.setNome("Ada Lovelace");
		medica.setPlantao(true);
		
		medica.cadastrarPaciente(pac1);
		medica.cadastrarPaciente(pac2);
		medica.cadastrarPaciente(pac3);
		
		medica.imprimirRelatorioPacientes(2);
		
		
	}

}
