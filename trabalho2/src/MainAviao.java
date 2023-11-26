import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class MainAviao {
	public static void main(String[] args) {
		int clima; // 1 = Ensolarado, 2 = Nublado
		List <Aviao> arquivo = new ArrayList<>();
		Random random = new Random();
		Scanner In = new Scanner(System.in);
		int op=1;
		Pista P1 = new Pista();
		P1.setNumero(1);
		Pista P2 = new Pista();
		P2.setNumero(2);
		Pista PD = new Pista();
		PD.setNumero(3);
		boolean x = false; //verificar se ja passou por todo arquivo
		while(op!=0) {
			//Bloco de Organização
			System.out.println("============================================================================");
			P1.organizar(P2, PD);
			clima = random.nextInt(2)+1;
			P1.decrementar();
			P2.decrementar();
			System.out.println("CENTRAL DE AEROPORTO");
			if(clima==1)
				System.out.println("-> CLIMA ENSOLARADO");
			else if(clima==2)
				System.out.println("-> CLIMA NUBLADO");
			System.out.println();	
			System.out.println();	
			System.out.println();	
			System.out.println("\u001B[36m[ PISTA 1 ]");
			P1.imprimir();
			P1.tempoMedioFila();
			System.out.println();	
			System.out.println();	
			System.out.println();	
			System.out.println("\u001B[32m[ PISTA 2 ]");
			P2.imprimir();
			P2.tempoMedioFila();
			System.out.println();	
			System.out.println();	
			System.out.println();	
			System.out.println("\u001B[31m[ PISTA DE DECOLAGEM ]");
			PD.imprimir();
			PD.tempoMedioFila();
			System.out.println();	
			System.out.println();	
			System.out.println();	
			System.out.println("\u001B[0m1) Cadastrar aviões manualmente");
			System.out.println("2) Entrar com aviões do arquivo");
			System.out.println("3) Aviões aleátorios");
			System.out.println("0) Sair");
			System.out.print("Opção Desejada: ");
			op = In.nextInt();
			In.nextLine();
			if(op==1) {
				int quantidade=0;
				do {
				System.out.print("Quantidade de Aviãos: ");
				quantidade = In.nextInt();
				In.nextLine();
				} while(quantidade<=0||quantidade>3);
				//Criando Aviao 1
				Aviao temp1 = P1.criarAviao(clima, In);
				P1.comparar(P2).inserirA(temp1);
				//Criando Aviao 2
				if(quantidade>1) {
					Aviao temp2 = P1.criarAviao(clima, In);
					P1.comparar(P2).inserirA(temp2);
				}
				//Criando Aviao 3
				if(quantidade>2) {
					Aviao temp3 = P1.criarAviao(clima, In);
					P1.comparar(P2).inserirA(temp3);
				}
				P1.organizar(P2, PD);
			}
			if(op==2) {
				//Lendo arquivo
				String caminhoDoArquivo = "E:\\GitHub\\trabalho2\\trabalho2\\src\\entrada.txt";
				if(x==false) {
			        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
			            String linha;
			            while ((linha = br.readLine()) != null) {
			            	int id;
			                Aviao temp1 = new Aviao();
			                double passageiros = Double.parseDouble(linha); // converte a linha para double
							String chassi;
						
							// Gerar uma identificação aleatória para o avião
							StringBuilder sb = new StringBuilder();
							String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
						
							for (int i = 0; i < 6; i++) { // Geração de ID com 6 caracteres
								int index = random.nextInt(caracteresPermitidos.length());
								char caractereAleatorio = caracteresPermitidos.charAt(index);
								sb.append(caractereAleatorio);
							}
							
							chassi = sb.toString();
							temp1.setIdentification(chassi);
			                temp1.setPassageiros(passageiros);
			                linha = br.readLine();
			                temp1.setCompanhia(linha);
			                linha = br.readLine();
			                int combustivel = Integer.parseInt(linha);
			                temp1.setCombustivel(combustivel); // converte a linha para inteiro
			                if(combustivel%2==0) {
			        			id = combustivel-1;
			        		} else {
			        			id = combustivel;
			        		}
			                temp1.setId(id);
			                arquivo.add(temp1);
			                }
			            x = true;
			            System.out.println("- ARQUIVO LIDO COM SUCESSO -");
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				} else {
					for(int a=0;a<3;a++) {
						if(arquivo.isEmpty()) {
							System.out.println("Arquivo Lido por COMPLETO");
							System.out.println("Pode-se REESCREVER o arquivo agora");
							x = false;
							break;
						}
						Aviao temp2 = arquivo.get(0);
						arquivo.remove(0);
						P1.comparar(P2).inserirA(temp2);
					}
				}
				P1.organizar(P2, PD);
			}
			if(op==3) {
				//Geração Aleátoria
				int quantidade = random.nextInt(3)+1;
				//Criando Aviao 1
				System.out.println("[ QUANTIDADE DE AVIÃOS ALEATÓRIOS: ] = " + quantidade);
				Aviao temp1 = P1.criarAviaoRandom(clima);
				P1.comparar(P2).inserirA(temp1);
				//Criando Aviao 2
				if(quantidade>1) {
					Aviao temp2 = P1.criarAviaoRandom(clima);
					P1.comparar(P2).inserirA(temp2);
				}
				//Criando Aviao 3
				if(quantidade>2) {
					Aviao temp3 = P1.criarAviaoRandom(clima);
					P1.comparar(P2).inserirA(temp3);
				}
				P1.organizar(P2, PD);
			}
			//pos execução
		}
	}
}
