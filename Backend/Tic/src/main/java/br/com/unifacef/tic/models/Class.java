package br.com.unifacef.tic.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_turma")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Integer Semester;
	private	Course course;
	
	public Class() {};

	public Class(Integer id, Integer semester, Course course) {
		Id = id;
		Semester = semester;
		this.course = course;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getSemester() {
		return Semester;
	}

	public void setSemester(Integer semester) {
		Semester = semester;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Class [Id=" + Id + ", Semester=" + Semester + ", course=" + course.toString() + "]";
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
		Class other = (Class) obj;
		return Objects.equals(Id, other.Id);
	};
}
