package hospitalManagementSystem.model.dao;

import hospitalManagementSystem.model.entities.Paciente;

public interface PacienteDao {
	void insert(Paciente obj);

	void deleteByCpf(String cpf);

	Paciente findByCpf(String cpf);
	
	void updateTelefoneByCpf(String cpf, String telefone);
}
