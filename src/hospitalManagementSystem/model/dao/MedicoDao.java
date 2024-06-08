package hospitalManagementSystem.model.dao;

import hospitalManagementSystem.model.entities.Medico;

public interface MedicoDao {
	void insert(Medico obj);

	void deleteByCrm(String crm);

	Medico findByCrm(String crm);

	void updateTelefoneByCrm(String crm, String telefone);

}
