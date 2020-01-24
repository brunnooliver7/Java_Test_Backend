package com.example.clientes.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "clientes")
public class ClienteEntity {

	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotEmpty	
	private String cpf;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<EnderecoEntity> endereco;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@NotNull
	private List<TelefoneEntity> telefone;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@NotNull
	private List<EmailEntity> email;

	// Getters & Setters
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String CPF) {
		cpf = CPF;
	}
	public List<EnderecoEntity> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<EnderecoEntity> endereco) {
		this.endereco = endereco;
	}
	public List<TelefoneEntity> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<TelefoneEntity> telefone) {
		this.telefone = telefone;
	}
	public List<EmailEntity> getEmail() {
		return email;
	}
	public void setEmail(List<EmailEntity> email) {
		this.email = email;
	}

	// HashCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
		
}