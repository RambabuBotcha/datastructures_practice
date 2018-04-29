package test;

public class Person {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;
	private Integer id;
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
}
