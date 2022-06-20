package br.com.unifacef.tic.models;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private Professor professor;
	private ArrayList<Task> tasks;
	
	public Subject() {}

	public Subject(Integer id, String name, Professor professor) {
		super();
		Id = id;
		Name = name;
		this.professor = professor;
		this.tasks = new ArrayList<>();
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

	@Override
	public String toString() {
		return "Subject [Id=" + Id + ", Name=" + Name + ", professor=" + professor.toString() + "]";
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
		Subject other = (Subject) obj;
		return Objects.equals(Id, other.Id);
	};
}
