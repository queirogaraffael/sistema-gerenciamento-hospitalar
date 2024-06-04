package hospitalManagementSystem.model.dao;

import hospitalManagementSystem.db.DB;
import hospitalManagementSystem.model.dao.service.MedicoDaoJDBC;
import hospitalManagementSystem.model.dao.service.PacienteDaoJDBC;

public class DaoFactory {

	public static MedicoDao createMedicoDao() {
		return new MedicoDaoJDBC(DB.getConnection());
	}

	public static PacienteDao createPacienteDao() {
		return new PacienteDaoJDBC(DB.getConnection());
	}

}
