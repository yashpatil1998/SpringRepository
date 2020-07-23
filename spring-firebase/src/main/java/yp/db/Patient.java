package yp.db;

public class Patient {

	private String name;
	private int age;
	private String city;

	public Patient(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Patient() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}
