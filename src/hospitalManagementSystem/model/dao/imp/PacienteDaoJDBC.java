package hospitalManagementSystem.model.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import hospitalManagementSystem.db.DB;
import hospitalManagementSystem.db.Exceptions.DbException;
import hospitalManagementSystem.db.Exceptions.DbIntegrityException;
import hospitalManagementSystem.model.dao.PacienteDao;
import hospitalManagementSystem.model.entities.Paciente;

public class PacienteDaoJDBC implements PacienteDao {

	private Connection conn;

	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Paciente findByCpf(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pacientes WHERE cpf = ?");
			st.setString(1, cpf);
			rs = st.executeQuery();

			if (rs.next()) {
				Paciente obj = new Paciente();
				obj.setCpf(rs.getString("cpf"));
				obj.setNome(rs.getString("nome"));
				obj.setIdade(rs.getInt("idade"));
				obj.setEndereco(rs.getString("endereco"));
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
	public void insert(Paciente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO pacientes " + "(cpf, nome, idade, endereco, telefone) " + "VALUES "
					+ "(?, ?, ?, ?, ?)");

			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNome());
			st.setInt(3, obj.getIdade());
			st.setString(4, obj.getEndereco());
			st.setString(5, obj.getTelefone());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected == 0) {
				throw new DbException("Erro inesperado! Nenhuma linha afetada!");
			} else {
				JOptionPane.showMessageDialog(null, "Novo paciente cadastrado com sucesso!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByCpf(String cpf) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM pacientes WHERE cpf = ?");

			st.setString(1, cpf);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "Paciente deletado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Operacao falhou: registro nao encontrado.");
			}

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void updateTelefoneByCpf(String cpf, String telefone) {
		PreparedStatement st = null;
		try {

			st = conn.prepareStatement("UPDATE pacientes " + "SET telefone = ? " + "WHERE " + "cpf = ?");

			st.setString(1, telefone);
			st.setString(2, cpf);

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
