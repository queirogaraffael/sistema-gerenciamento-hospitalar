package hospitalManagementSystem.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private String nome;
	private int idade;
	private String endereco;
	private String telefone;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Paciente() {
	}

	public Paciente(String cpf, String nome, int idade, String endereco, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Paciente: ").append("Nome: ").append(nome).append(", CPF: ").append(cpf).append(", Idade : ")
				.append(idade).append(", Telefone: ").append(telefone).append(", Endereco: ").append(endereco);

		return sb.toString();

	}
}
