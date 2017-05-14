package tads;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<Person> pessoas;
	
	public Agenda() {
		this.pessoas = new ArrayList<>();
	}

	public List<Person> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Person> pessoas) {
		this.pessoas = pessoas;
	}
	
	public String checkPersons(){
		StringBuilder sb = new StringBuilder();
		
		//vê se a lista está vazia, senão mostra os registros
		if (this.pessoas.isEmpty())
			sb.append("\nNão há registro de pessoas na agenda.\n");
		else {
			for (Person pes : this.pessoas){
				sb.append("\n"+pes.toString());
			}
		}
		return sb.toString();
	}
}