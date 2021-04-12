package com.practice.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student 
{
	@Id
	@NotNull(message = "Error! ID cannot be blank")
	@Min(value = 1, message = "Error! ID cannot be zero or less than 0")
	private int id;
	
	@NotBlank(message = "Error! Name cannot be blank")
	@Size(min = 3, max = 25)
	private String name;
	
	@NotNull(message = "Error! Please select gender")
	private String gender;
	
	@NotNull(message = "Error! Age cannot  be blank")
	@Min(value = 5, message = "Error! Age should not be less than 5")
	@Max(value = 125, message = "Error! Age should not be greater than 125")
	private int age;
	
	public Student() {}
	
	public Student(int id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
