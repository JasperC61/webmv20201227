package model;

public class Student {
	
	private String name;
	private int age;
	private String  sid;
	
	
	public Student() {
		
	}
	
	
	
	public String getSid() {
		return sid;
	}



	public void setSid(String sid) {
		this.sid = sid;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}




	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sid=" + sid + "]";
	}
	
	
	
	
	
	

}
