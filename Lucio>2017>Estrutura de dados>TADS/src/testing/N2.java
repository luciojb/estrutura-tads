package testing;

import java.util.Scanner;

import tads.Agenda;
import tads.Person;

public class N2 {
	
	public static void main(String[] args) {
		boolean exit = false;
		int option = 0;
		Scanner read = new Scanner(System.in);
		
		Agenda ag = new Agenda();
		Person p = new Person();
		
		//Escolha das opções principais e suas respectivas ações
		do {
			System.out.println("O que deseja fazer?\n"
					+ "1- Novo registro na agenda\n"
					+ "2- Registros existentes\n"
					+ "3- Remover elemento\n"
					+ "4- Sair");
			
			//tenta ler a opção
			option = read.nextInt();
			read.nextLine();
			//valida a opção
			while (option<1 || option>4){
				System.out.println("\nDigite uma opção válida: ");
				option = read.nextInt();
				read.nextLine();
			}
			
			//Novo registro?
			if (option ==1){
				
				p = new Person();
				while (p.getName() == null){
					System.out.println("\nNome: ");
					p.setName(read.nextLine());
				}
				
				//vê o que adicionar.
				do {
					option = 0;
					System.out.println("\n1- Novo Telefone"
							+ "\n2- Novo Endereco"
							+ "\n3- Voltar");
					try{
						option = read.nextInt();
					} catch (Exception e){
						option = 0;
						read.nextLine();
					}

					//valida
					while (option < 1 || option > 3){
						System.out.println("\nOpção: ");
						try{
							option = read.nextInt();
						} catch (Exception e){
							option = 0;
							read.nextLine();
						}
					}
					
					//telefone?
					if (option == 1){
						long tel = 0;
						while(tel == 0){
							try{
								System.out.println("\nTelefone: ");
								tel = read.nextLong();
							} catch (Exception e){
								tel = 0;
								read.nextLine();
							}
						}
						//adiciona telefone para a pessoa
						p.getPhones().add(tel);
					
					//endereço?
					} else if (option == 2){
						
						String address = "";
						
						//valida descricao do endereco
						while(address == ""){
							read.nextLine();
							try{
								System.out.println("\nDescrição / detalhamento: ");
								address = read.nextLine();
							} catch (Exception e){
								address = "";
								read.nextLine();
							}
						}
						
						//adiciona endereco a pessoa
						p.getAddresses().add(address);
						
					}
				} while(option!=3);
			//adiciona pessoa na agenda
			ag.getPessoas().add(p);
			
			//ver registros existentes?
			} else if (option == 2){
				System.out.println(ag.checkPersons());
			
			//excluir registro?
			} else if (option == 3){
				int count =1;
				
				//mostra as opções disponíveis
				System.out.println("Digite o número correspondente à opção: \n\\n"
						+ "0 = CANCELAR \n");
				for (Person pes: ag.getPessoas()){
					System.out.println(count+" - "+pes.getName()+"\n");
					count ++;
				}
				
				option = -1;
				//valida a opção escolhida
				while (option <0 || option > ag.getPessoas().size()){
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
					ag.getPessoas().remove(option-1);
			
			//sair? acaba a execução.
			} else if (option == 4){
				exit = true;
			}
			
		} while (! exit);
		read.close();
	}

}
