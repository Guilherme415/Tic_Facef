package br.com.unifacef.tic.models;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.unifacef.tic.models.enums.AdministratorEnum;

public class Associate {
	@Id
	protected Integer Code;
	protected String CPF, Name, Email;
	protected AdministratorEnum Administrator;
	
	public Associate() {}

	public Associate(Integer code, String cPF, String name, String email, AdministratorEnum administrator) {
		this.Code = code;
		CPF = cPF;
		Name = name;
		Email = email;
		Administrator = administrator;
	}
	
	public Integer getCode() {
		return Code;
	}

	public void setCode(Integer code) {
		Code = code;
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
		return "Associate [Id=" + Code + ", CPF=" + CPF + ", Name=" + Name + ", Email=" + Email + ", Administrator=" + Administrator
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Code);
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
		return Objects.equals(Code, other.Code);
	}
}
