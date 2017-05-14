package tads;

public class Customer {
	private String name;
	private int birthYear;
	private double income;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(double income) {
		if (income>0)
			this.income = income;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [name=");
		builder.append(name);
		builder.append(", birthYear=");
		builder.append(birthYear);
		builder.append(", income=");
		builder.append(String.format("R$%.2f", income));
		builder.append("]");
		return builder.toString();
	}	
	
	
}
