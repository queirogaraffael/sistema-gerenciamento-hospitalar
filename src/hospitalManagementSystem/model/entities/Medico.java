package hospitalManagementSystem.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	private String crm;
	private String nome;
	private String especialidade;
	private String telefone;

	public Medico() {

	}

	public Medico(String crm, String nome, String especialidade, String telefone) {

		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(crm, other.crm);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Medico: ").append("CRM: ").append(crm).append(", Nome: ").append(nome).append(", Especialidade:")
				.append(especialidade).append(", Telefone: ").append(telefone);

		return sb.toString();

	}

}
