package entity;

import java.io.Serializable;

public class Pet implements Serializable {
	
	private static final long serialVersionUID = 8003844535317504274L;
	private String name;
	private String type;
	private int age;

	public Pet(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public void makeNoise() {
		String noise = "";
		switch (type.toLowerCase()) {
		case "cat":
			noise = "meow";
			break;
		case "dog":
			noise = "bark";
			break;
		default:
			noise = "some noise";
		}
		System.out.println(name + " " + type + " says " + noise);
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + "]";
	}
}
