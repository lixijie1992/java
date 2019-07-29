package com.lixijie.mybatisdemo.pojo;

public class Student {
	private Integer id;
	private String name;
	private double score;
	private int age;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student( String name, double score, int age) {
		super();
		this.name = name;
		this.score = score;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + ", age=" + age + "]";
	}

}
