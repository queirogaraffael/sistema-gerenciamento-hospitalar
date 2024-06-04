package hospitalManagementSystem.controller;

import javax.swing.JOptionPane;

import hospitalManagementSystem.constantes.MenuPrincipalConstantes;
import hospitalManagementSystem.db.DB;
import hospitalManagementSystem.model.dao.DaoFactory;
import hospitalManagementSystem.model.dao.MedicoDao;
import hospitalManagementSystem.model.dao.PacienteDao;
import hospitalManagementSystem.model.entities.Medico;
import hospitalManagementSystem.model.entities.Paciente;
import hospitalManagementSystem.view.MenuPrincipalView;

public class HospitalManagerController {

	private PacienteDao pacienteDao;
	private MedicoDao medicoDao;

	public HospitalManagerController() {
		this.pacienteDao = DaoFactory.createPacienteDao();
		this.medicoDao = DaoFactory.createMedicoDao();
	}

	public void menuPrincipal() {
		String opcao = "";
		do {

			try {

				opcao = MenuPrincipalView.menuPrincipalView();

				switch (opcao) {
				case (MenuPrincipalConstantes.ADICIONA_PACIENTE):
					adicionaPaciente();
					break;
				case (MenuPrincipalConstantes.ADICIONA_MEDICO):
					adicionaMedico();
					break;
				case (MenuPrincipalConstantes.PESQUISA_PACIENTE_CPF):
					pesquisaPacientePeloCpf();
					break;
				case (MenuPrincipalConstantes.PESQUISA_MEDICO_CRM):
					pesquisaMedicoPeloCrm();
					break;
				case (MenuPrincipalConstantes.EXCLUI_PACIENTE_CPF):
					excluiPacientePeloCpf();
					break;
				case (MenuPrincipalConstantes.EXCLUIR_MEDICO_CRM):
					excluiMedicoPeloCrm();
					break;
				case (MenuPrincipalConstantes.MODIFICA_NUMERO_PACIENTE):
					modificaNumeroTelefonePaciente();
					break;
				case (MenuPrincipalConstantes.MODIFICA_NUMERO_MEDICO):
					modificaNumeroTelefoneMedico();
					break;
				case (MenuPrincipalConstantes.SAIR):
					DB.closeConnection();
					break;

				}

			} catch (NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Entrada de dados invalida. Tente novamente!");
			}

		} while (opcao != MenuPrincipalConstantes.SAIR);
	}

	private void adicionaPaciente() {

		String cpf = JOptionPane.showInputDialog("Digite o CPF: ");

		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "Campo obrigatorio. Tente novamente!");
		} else {
			if (pacienteDao.findByCpf(cpf) == null) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
				String endereco = JOptionPane.showInputDialog("Digite o endereco: ");
				String telefone = JOptionPane.showInputDialog("Digite o telefone: ");

				Paciente paciente = new Paciente(cpf, nome, idade, endereco, telefone);

				pacienteDao.insert(paciente);
			} else {
				JOptionPane.showMessageDialog(null, "Paciente ja cadastrado!");
			}
		}

	}

	private void adicionaMedico() {

		String crm = JOptionPane.showInputDialog("Digite o CRM: ");

		if (crm.equals("")) {
			JOptionPane.showMessageDialog(null, "Campo obrigatorio. Tente novamente!");
		} else {
			if (medicoDao.findByCrm(crm) == null) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				String especialidade = JOptionPane.showInputDialog("Digite o nome da especialidade: ");
				String telefone = JOptionPane.showInputDialog("Digite o telefone: ");

				Medico medico = new Medico(crm, nome, especialidade, telefone);

				medicoDao.insert(medico);
			} else {
				JOptionPane.showMessageDialog(null, "Medico ja cadastrado!");
			}
		}

	}

	private void pesquisaPacientePeloCpf() {

		String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: ");

		Paciente paciente = pacienteDao.findByCpf(cpf);

		if (paciente == null) {
			JOptionPane.showMessageDialog(null, "Sem paciente com esse CPF");
		} else {
			JOptionPane.showMessageDialog(null, paciente);
		}

	}

	private void pesquisaMedicoPeloCrm() {

		String crm = JOptionPane.showInputDialog("Digite o CRM do medico: ");

		Medico medico = medicoDao.findByCrm(crm);

		if (medico == null) {
			JOptionPane.showMessageDialog(null, "Sem medico com esse CRM");
		} else {
			JOptionPane.showMessageDialog(null, medico);
		}

	}

	private void excluiPacientePeloCpf() {

		String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: ");

		pacienteDao.deleteByCpf(cpf);

	}

	private void excluiMedicoPeloCrm() {

		String crm = JOptionPane.showInputDialog("Digite o CRM do medico: ");

		medicoDao.deleteByCrm(crm);

	}

	private void modificaNumeroTelefonePaciente() {
		String cpf = JOptionPane.showInputDialog("Digite o CPF: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone: ");

		pacienteDao.atualizaTelefonePeloCpf(cpf, telefone);

	}

	private void modificaNumeroTelefoneMedico() {

		String crm = JOptionPane.showInputDialog("Digite o CRM: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone: ");

		medicoDao.atualizaTelefonePeloCrm(crm, telefone);

	}
}
