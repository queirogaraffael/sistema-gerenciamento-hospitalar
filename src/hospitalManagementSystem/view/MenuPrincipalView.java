package hospitalManagementSystem.view;

import javax.swing.JOptionPane;

public class MenuPrincipalView {

	public static String menuPrincipalView() {

		Object[] opcoesMenu = { "Adicionar novo paciente", "Adicionar novo medico", "Pesquisar paciente por CPF",
				"Pesquisar medico por CRM", "Excluir paciente pelo CPF", "Excluir medico pelo CRM",
				"Modificar telefone do paciente", "Modificar telefone do medico", "Sair do sistema" };

		Object opcaoSelecionada = JOptionPane.showInputDialog(null, "Escolha uma opcao:", "Menu Principal",
				JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

		if (opcaoSelecionada != null) {
			return opcaoSelecionada.toString();
		} else {
			return "";
		}

	}

}
