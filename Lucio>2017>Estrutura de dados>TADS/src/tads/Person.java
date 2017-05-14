package tads;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private List<Long> phones;
	private List<String> addresses;
	
	public Person() {
		this.phones = new ArrayList<>();
		this.addresses = new ArrayList<>();
	}
	
	public void setName(String name){
		this.name = name;
	}

	public List<Long> getPhones() {
		return phones;
	}

	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", phones=");
		for (long i : this.phones){
			builder.append("[phone= ");
			builder.append(i);
			builder.append("]");
		}
		builder.append(", addresses=");
		for (String a: this.addresses){
			builder.append("[address= ");
			builder.append(a);
			builder.append("]");
		}
		builder.append("]\n");
		return builder.toString();
	}
}
