package br.com.unifacef.tic.models;

import java.util.Objects;

import br.com.unifacef.tic.models.enums.AdministratorEnum;

public class Associate {
	protected String CPF, Name, Email;
	protected AdministratorEnum Administrator;
	
	public Associate() {}

	public Associate(String cPF, String name, String email, AdministratorEnum administrator) {
		CPF = cPF;
		Name = name;
		Email = email;
		Administrator = administrator;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public AdministratorEnum getAdministrator() {
		return Administrator;
	}

	public void setAdministrator(AdministratorEnum administrator) {
		Administrator = administrator;
	}

	@Override
	public String toString() {
		return "Associate [CPF=" + CPF + ", Name=" + Name + ", Email=" + Email + ", Administrator=" + Administrator
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Administrator, CPF, Email, Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		return Administrator == other.Administrator && Objects.equals(CPF, other.CPF)
				&& Objects.equals(Email, other.Email) && Objects.equals(Name, other.Name);
	};
}
