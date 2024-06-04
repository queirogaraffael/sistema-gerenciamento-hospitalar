package hospitalManagementSystem.model.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import hospitalManagementSystem.db.DB;
import hospitalManagementSystem.db.DbException;
import hospitalManagementSystem.db.DbIntegrityException;
import hospitalManagementSystem.model.dao.MedicoDao;
import hospitalManagementSystem.model.entities.Medico;

public class MedicoDaoJDBC implements MedicoDao {

	private Connection conn;

	public MedicoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Medico findByCrm(String crm) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM medicos WHERE crm = ?");
			st.setString(1, crm);
			rs = st.executeQuery();

			if (rs.next()) {
				Medico obj = new Medico();
				obj.setCrm(rs.getString("crm"));
				obj.setNome(rs.getString("nome"));
				obj.setEspecialidade(rs.getString("especialidade"));
				obj.setTelefone(rs.getString("telefone"));

				return obj;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Medico obj) {
		PreparedStatement st = null;
		try {

			st = conn.prepareStatement(
					"INSERT INTO medicos " + "(crm, nome, especialidade, telefone) " + "VALUES " + "(?, ?, ?, ?)");

			st.setString(1, obj.getCrm());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getEspecialidade());
			st.setString(4, obj.getTelefone());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected == 0) {
				throw new DbException("Erro inesperado! Nenhuma linha afetada!");
			} else {
				JOptionPane.showMessageDialog(null, "Novo medico cadastrado com sucesso!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByCrm(String crm) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM medicos WHERE crm = ?");

			st.setString(1, crm);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "Medico deletado com sucesso!");
			} else {
				throw new DbException("Operacao falhou: registro nao encontrado.");
			}

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizaTelefonePeloCrm(String crm, String telefone) {
		PreparedStatement st = null;
		try {

			st = conn.prepareStatement("UPDATE medicos " + "SET telefone = ? " + "WHERE " + "crm = ?");

			st.setString(1, telefone);
			st.setString(2, crm);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Modificado com sucesso!");
			} else {
				throw new DbException("Problemas na atualizacao dos dados.");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

}
