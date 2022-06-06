package br.com.unifacef.tic.models;

import br.com.unifacef.tic.models.enums.AdministratorEnum;

public class Student extends Associate {
	private Integer Code, CourseId;
	
	public Student() {}

	public Student(String cPF, String name, String email, AdministratorEnum administrator, Integer code,
			Integer courseId) {
		super(cPF, name, email, administrator);
		Code = code;
		CourseId = courseId;
	}

	public Integer getCode() {
		return Code;
	}

	public void setCode(Integer code) {
		Code = code;
	}

	public Integer getCourseId() {
		return CourseId;
	}

	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}

	@Override
	public String toString() {
		return "Student [Code=" + Code + ", CourseId=" + CourseId + super.toString() + "]";
	};
}