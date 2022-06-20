package br.com.unifacef.tic.models;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_instituicao_superior")
public class Institution {
	
	@Id
	private Integer CNPJ;
	private String Name, City;
	private ArrayList<Course> courses;
	
	public Institution() {}

	public Institution(Integer cNPJ, String name, String city, ArrayList<Course> courses) {
		super();
		CNPJ = cNPJ;
		Name = name;
		City = city;
		this.courses = courses;
	}

	public Integer getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {
		CNPJ = cNPJ;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}
	
	public void deleteCourses(Course course) {
		this.courses.remove(course);
	}

	@Override
	public String toString() {
		return "Institution [CNPJ=" + CNPJ + ", Name=" + Name + ", City=" + City + ", courses=" + courses + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CNPJ);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Institution other = (Institution) obj;
		return Objects.equals(CNPJ, other.CNPJ);
	};
}
