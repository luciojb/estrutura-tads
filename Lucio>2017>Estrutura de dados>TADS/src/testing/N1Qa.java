package testing;

import java.util.Scanner;
import tads.Date;

public class N1Qa {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		
		Date newDate = new Date();
		
		try{
			System.out.println("Digitação de data: digite o dia: ");
			newDate.dia = read.nextInt();
			System.out.println("\nMês: ");
			newDate.mes = read.nextInt();
			System.out.println("\nAno: ");
			newDate.ano = read.nextInt();
			
				if (newDate.validateDayMonthYear(newDate.dia, newDate.mes, newDate.ano))
					System.out.println("\nData válida!!! --> "+newDate.toString());
				else 
					System.out.println("\nData inválida!!!");
		} catch (Exception e){
			System.out.println("\nEntrada inválida!!!");
		} finally {
			read.close();
		}	
	}
}
