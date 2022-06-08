package br.com.unifacef.tic.models;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.unifacef.tic.models.enums.AdministratorEnum;

public class Professor extends Associate {
	private ArrayList<Calendar> Schedular;
	private ArrayList<Subject> Subjects;
	
	public Professor() {}

	public Professor(Integer codig, String cPF, String name, String email, AdministratorEnum administrator) {
		super(codig, cPF, name, email, administrator);
		this.Schedular = new ArrayList<>();
		this.Subjects = new ArrayList<>();
	}
	
	public Professor(Integer codig, String cPF, String name, String email, AdministratorEnum administrator,
			ArrayList<Calendar> schedular) {
		super(codig, cPF, name, email, administrator);
		Schedular = schedular;
		this.Subjects = new ArrayList<>();
	}
	
	public Professor(Integer codig, String cPF, String name, String email, AdministratorEnum administrator,
			ArrayList<Calendar> schedular, ArrayList<Subject> subjects) {
		super(codig, cPF, name, email, administrator);
		Schedular = schedular;
		Subjects = subjects;
	}

	public ArrayList<Calendar> getSchedular() {
		return Schedular;
	}
	
	public ArrayList<Subject> getSubject() {
		return this.Subjects;
	}

	public void addScheludar(Calendar date) {
		this.Schedular.add(date);
	}
	
	public void deleteScheludar(Calendar date) {
		this.Schedular.remove(date);
	}
	
	public void addSubject(Subject subject) {
		this.Subjects.add(subject);
	}
	
	public void deleteSubject(Subject subject) {
		this.Subjects.remove(subject);
	}

	@Override
	public String toString() {
		return "Professor [Schedular=" + Schedular + super.toString() + "]";
	};
}
