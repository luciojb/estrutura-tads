package testing;

import java.util.Scanner;

import tads.Company;
import tads.Customer;

public class N3 {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		Company c = new Company();
		Customer cl = new Customer();
		boolean exit = false;
		int option = 0;
		
		//Escolha das opções principais e suas respectivas ações
		do {
			System.out.println("O que deseja fazer?\n"
					+ "1- Novo registro de cliente\n"
					+ "2- Registros existentes\n"
					+ "3- Remover cliente\n"
					+ "4- Clientes com renda acima da média\n"
					+ "5- Clientes nascidos entre 1980 e 2000\n"
					+ "6- Sair");
			
			//tenta ler a opção
			option = read.nextInt();
			read.nextLine();
			//valida a opção
			while (option<1 || option>6){
				System.out.println("\nDigite uma opção válida: ");
				option = read.nextInt();
				read.nextLine();
			}
			
			//Novo registro?
			if (option ==1){
				
				cl = new Customer();
				while (cl.getName() == null){
					System.out.println("\nNome: ");
					cl.setName(read.nextLine());
				}
				
				while(cl.getBirthYear()<=1900){
					try{
						System.out.println("\nAno de Nascimento: ");
						cl.setBirthYear(read.nextInt());
					} catch (Exception e){
						cl.setBirthYear(0);
						read.nextLine();
					}
				}
				
				while(cl.getIncome()<=0){
					try{
						System.out.println("\nRenda mensal, ex. 1900,00: ");
						cl.setIncome(read.nextDouble());
					} catch (Exception e){
						System.out.println("\nEntreda inválida. Decimais com vírgula!\n");
						cl.setIncome(-1);
						read.nextLine();
					}
				}
				
			//adiciona cliente
			c.getCustomers().add(cl);
			
			//ver registros existentes?
			} else if (option == 2){
				System.out.println(c.checkClients());
			
			//excluir registro?
			} else if (option == 3){
				int count =1;
				
				//mostra as opções disponíveis
				System.out.println("Digite o número correspondente à opção: \n\n"
						+ "0 = CANCELAR \n");
				for (Customer cus: c.getCustomers()){
					System.out.println(count+" - "+cus.getName()+"\n");
					count ++;
				}
				
				option = -1;
				//valida a opção escolhida
				while (option <0 || option > c.getCustomers().size()){
					try{
						System.out.println("\nOpção: ");
						option = read.nextInt();
					} catch (Exception e){
						option = -1;
						read.nextLine();
					}
				}
				//se não for cancelar, retira opção. "-1" pra arrumar o índice hahaha
				if (option > 0)
					c.getCustomers().remove(option-1);
			
			//sair? acaba a execução.
			} else if (option == 4){
				System.out.printf(">>>Clientes com renda acima da média ( R$%.2f %s %d %s", c.getMedia(), ") --> ", c.getMaioresMedia(), "\n\n");
			} else if (option == 5){
				System.out.println(">>>Clientes nascidos entre 1980 e 2000 --> "+c.getBetweenDate()+"\n\n");
			} else if (option == 6){
				exit = true;
			}
			
		} while (! exit);
		read.close();
	}
}
