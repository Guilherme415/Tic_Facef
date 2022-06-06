package br.com.unifacef.tic.models;

import java.util.Calendar;
import java.util.Objects;

public class Task {
	private Integer Id;
	private float Grade;
	private Calendar Deadline;
	private Subject subject;
	
	public Task() {}

	public Task(Integer id, float grade, Calendar deadline, Subject subject) {
		super();
		Id = id;
		Grade = grade;
		Deadline = deadline;
		this.subject = subject;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public float getGrade() {
		return Grade;
	}

	public void setGrade(float grade) {
		Grade = grade;
	}

	public Calendar getDeadline() {
		return Deadline;
	}

	public void setDeadline(Calendar deadline) {
		Deadline = deadline;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Tasks [Id=" + Id + ", Grade=" + Grade + ", Deadline=" + Deadline + ", subject=" + subject.toString() + "]";
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
		Task other = (Task) obj;
		return Objects.equals(Id, other.Id);
	};
}
