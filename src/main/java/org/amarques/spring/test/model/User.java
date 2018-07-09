package org.amarques.spring.test.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class User {

	@NotNull(message = "User ID cannot be null")
	private String id;
	@NotNull(message = "User name cannot be null")
	private String name;
	
	private String gender;
	private Integer age;

	@JsonProperty ("id")
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	@JsonProperty ("name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@JsonProperty ("gender")
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }

	@JsonProperty ("age")
	public Integer getAge() { return age; }
	public void setAge(Integer age) { this.age = age; }
}