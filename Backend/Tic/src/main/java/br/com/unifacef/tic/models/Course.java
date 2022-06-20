package br.com.unifacef.tic.models;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private String Period;
	private ArrayList<Subject> subjects;
	private ArrayList<Class> classes;
	private Institution institution;
	
	public Course() {}

	public Course(Integer id, String name, String period, ArrayList<Subject> subjects, 
			ArrayList<Class> classes, Institution institution) {
		Id = id;
		Name = name;
		Period = period;
		this.subjects = subjects;
		this.classes = classes;
		this.institution = institution;
	}

	public Course(Integer id, String name, String period, Institution institution) {
		Id = id;
		Name = name;
		Period = period;
		this.subjects = new ArrayList<>();
		this.classes = new ArrayList<>();
		this.institution = institution;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPeriod() {
		return Period;
	}

	public void setPeriod(String period) {
		Period = period;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	public ArrayList<Class> getClasses() {
		return classes;
	}
	
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", Name=" + Name + ", Period=" + Period + ", subjects=" + subjects.toString() + ", classes=" + classes.toString() + ", institution: " + institution.toString() + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(Id, other.Id);
	};
}
