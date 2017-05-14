package testing;

import java.util.Scanner;

import tads.Date;

public class N1Qb {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Date dateValidator = new Date();
		
		try{
			System.out.println("Digitação uma data no formato dd/mm/aaaa, ex. 29/02/2016: ");
			dateValidator.date = read.next();
			
				if (dateValidator.validateStringDate(dateValidator.date))
					System.out.println("\nData válida!!! --> "+dateValidator.date);
				else 
					System.out.println("\nData inválida!!!");
		} catch (Exception e){
			System.out.println("\nEntrada inválida!!!");
		} finally {
			read.close();
		}
	}
}
