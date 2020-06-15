package dataStorage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person {
	private int id;
private	String firstName;
private	String lastName;
private int age;
private String position;
private	String city;
private char gender;
public Person(int id, String firstName, String lastName, int age, String position, String city, char gender) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.position = position;
	this.city = city;
	this.gender = gender;
}

public String getPersonNameAndPositionInfo() {
	return this.firstName+" "+ this.lastName +", position:"+this.position+" in "+ this.city;
	}


}
