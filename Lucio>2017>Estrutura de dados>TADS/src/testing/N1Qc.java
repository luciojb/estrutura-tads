package testing;

import java.util.Scanner;

import tads.Date;

public class N1Qc {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		Date newDate = new Date();
		
		try{
			System.out.println("Digitação uma data no formato dd/mm/aaaa, ex. 29/02/2016: ");
			newDate.date = read.next();
			
			System.out.println(newDate.writeLongDate(newDate.date));
			
		} catch (Exception e){
			System.out.println("\nEntrada inválida!!!");
		} finally {
			read.close();
		}
	}
}
