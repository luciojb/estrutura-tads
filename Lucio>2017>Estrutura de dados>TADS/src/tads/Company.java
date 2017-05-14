package tads;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<Customer> customers;
	
	public Company() {
		this.customers = new ArrayList<>();
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public double getMedia(){
		double total = 0;
		for (Customer c : this.customers){
			total += c.getIncome();
		}
		return total / this.customers.size();
	}
	
	public int getMaioresMedia(){
		double media = this.getMedia();
		int count = 0;
		for (Customer c : this.customers){
			if (c.getIncome()>media){
				count++;
			}
		}
		return count;
	}
	
	public int getBetweenDate(){
		int count = 0;
		for (Customer c : this.customers){
			if (c.getBirthYear()>=1980 || c.getBirthYear()<=2000){
				count++;
			}
		}
		return count;
	}
	
	public String checkClients(){
		StringBuilder sb = new StringBuilder();
		
		//vê se a lista está vazia, senão mostra os registros
		if (this.customers.isEmpty())
			sb.append("\nNão há registro de pessoas na agenda.\n");
		else {
			for (Customer c : this.customers){
				sb.append("\n"+c.toString());
			}
		}
		return sb.toString();
	}
}
