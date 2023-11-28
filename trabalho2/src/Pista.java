import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Pista {
	private int numero;
	private List <Aviao> fila1 = new ArrayList<>();
	private List <Aviao> fila2 = new ArrayList<>();
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Aviao> getFila1() {
		return fila1;
	}
	public void setFila1(List<Aviao> fila1) {
		this.fila1 = fila1;
	}
	public List<Aviao> getFila2() {
		return fila2;
	}
	public void setFila2(List<Aviao> fila2) {
		this.fila2 = fila2;
	}
	public Pista() {
		
	}
	public Pista(List<Aviao> fila1, List<Aviao> fila2, int numero) {
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.numero = numero;
	}
	public void inserirA(Aviao a) {
		if (this.getNumero() == 3) {
			// Se for a pista 3, imprime a mensagem em rosa
			System.out.print("\u001B[35mFila de Decolagem\u001B[0m");
		} else if(this.getNumero() == 1){
			System.out.print("\u001B[36mFila de Aterrisagem\u001B[0m");
		} else if(this.getNumero() == 2){
			System.out.print("\u001B[32mFila de Aterrisagem\u001B[0m");
		}
		
		if(fila1.size()>fila2.size()) {
			this.fila2.add(a);
			System.out.println("-> Avião com ID:" + a.getId() + " Chassi: " + a.getIdentification() + " adicionado na Fila 2 da [PISTA " + this.getNumero() + "]");
		} else if(fila2.size()>fila1.size()){
			System.out.println("-> Avião com ID:" + a.getId() + " Chassi: " + a.getIdentification() + " adicionado na Fila 1 [PISTA " + this.getNumero() + "]" );
			this.fila1.add(a);
		} else {
			System.out.println("-> Avião com ID:" + a.getId() + " Chassi: " + a.getIdentification() + " adicioando na Fila 1 [PISTA " + this.getNumero() + "]");
			this.fila1.add(a);
		}
	}
	public void imprimir() {
		if(fila1.size()>0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("------------------");
			System.out.println("FILA 1");
			System.out.println("------------------");
		}
		for(int a=0;a<this.fila1.size();a++) {
			System.out.println("Avião [" + a + "]");
			System.out.println("ID: " + fila1.get(a).getId());
			System.out.println("QUANTIDADE DE PASSAGEIROS: " + fila1.get(a).getPassageiros());
			System.out.println("COMPANHIA: " + fila1.get(a).getCompanhia());
			System.out.println("COMBUSTIVEL: " + fila1.get(a).getCombustivel());
			System.out.println("ESTADO DE EMERGENCIA: " + fila1.get(a).getEmergencia());
			System.out.println("Chassi: " + fila1.get(a).getIdentification());
			System.out.println("------------------");
		}
		if(fila2.size()>0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("------------------");	
			System.out.println("FILA 2");
			System.out.println("------------------");	
		}
		for(int a=0;a<this.fila2.size();a++) {
			System.out.println("Avião [" + a + "]");
			System.out.println("ID: " + fila2.get(a).getId());
			System.out.println("QUANTIDADE DE PASSAGEIROS: " + fila2.get(a).getPassageiros());
			System.out.println("COMPANHIA: " + fila2.get(a).getCompanhia());
			System.out.println("COMBUSTIVEL: " + fila2.get(a).getCombustivel());
			System.out.println("ESTADO DE EMERGENCIA: " + fila2.get(a).getEmergencia());
			System.out.println("Chassi: " + fila2.get(a).getIdentification());
			System.out.println("------------------");
		}
	}
	public Aviao criarAviao(int clima, Scanner In) {
		Aviao temp1 = new Aviao();
		int combustivel,passageiros,comp,emergencia=0,id;
		char necessidade;
		String companhia=" ";
		Random random = new Random();
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
		
		do {
		System.out.print("Quantidade de Passageiros: ");
		passageiros = In.nextInt();
		In.nextLine(); // limpar buffer
		} while (passageiros<0);
		
		do {
		System.out.print("Há passageiros com Necessidade [S/N]: ");
		necessidade = In.next().charAt(0);
		necessidade = Character.toUpperCase(necessidade); // Maiusculo
		} while(necessidade!='S' && necessidade!='N');
		
		if(necessidade=='S'&&clima==2) {
			System.out.println("Avião em Estado de EMERGÊNCIA");
			emergencia = 1;
		}
		
		do {
		System.out.println("1 -> GOL");
		System.out.println("2 -> LATAM");
		System.out.println("3 -> AZUL");
		System.out.println("4 -> American Airlines");
		System.out.print("Escolha uma das Companhias acima:");
		comp = In.nextInt();
		if(comp==1)
			companhia = "GOL";
		else if(comp==2)
			companhia = "LATAM";
		else if(comp==3)
			companhia = "AZUL";
		else if(comp==4)
			companhia = "American Airlines";
		} while(comp<1 ||comp>4);
		
		do {
		System.out.print("Digite a quantidade de combustivel [1-15]:");
		combustivel = In.nextInt();
		} while(combustivel>15 || combustivel<1);
		if(combustivel%2==0) {
			id = combustivel-1;
		} else {
			id = combustivel;
		}
		
		temp1.setIdentification(chassi);
		temp1.setId(id);
		temp1.setCombustivel(combustivel);
		temp1.setCompanhia(companhia);
		temp1.setPassageiros(passageiros);
		temp1.setEmergencia(emergencia);
		return temp1;
	}
	public Aviao criarAviaoRandom(int clima) {
		Aviao temp1 = new Aviao();
		int combustivel, passageiros, comp, emergencia = 0, id, necessidade;
		String companhia = " ";
		Random random = new Random();
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
	
		passageiros = random.nextInt(251) + 50; // entre 50 e 300
		necessidade = random.nextInt(2);
		if (necessidade == 1 && clima == 2) {
			emergencia = 1;
		}
		comp = random.nextInt(4) + 1;
		if (comp == 1)
			companhia = "GOL";
		else if (comp == 2)
			companhia = "LATAM";
		else if (comp == 3)
			companhia = "AZUL";
		else if (comp == 4)
			companhia = "American Airlines";
		combustivel = random.nextInt(15) + 1;
		if (combustivel % 2 == 0) {
			id = combustivel - 1;
		} else {
			id = combustivel;
		}
	
		temp1.setIdentification(chassi);
		temp1.setId(id);
		temp1.setCombustivel(combustivel);
		temp1.setCompanhia(companhia);
		temp1.setPassageiros(passageiros);
		temp1.setEmergencia(emergencia);
		return temp1;
	}
	public Pista comparar(Pista A) {
		//compara uma pista a outra e retorna a com fila menos disponivel
		if(this.getFila1().size()>A.getFila1().size())
			return A;
		else if(this.getFila1().size()>A.getFila2().size())
			return A;
		else if(this.getFila2().size()>A.getFila1().size())
			return A;
		else if(this.getFila2().size()>A.getFila2().size())
			return A;
		else
			return this;
	}
	public void organizar(Pista A,Pista decolagem,int entrada) {
		if(entrada == 0){
			try {
				if (decolagem.fila1.size() >= 1) {
					System.out.println("\u001B[31mAvião decolado com ID [" + decolagem.fila1.get(0).getId() + "]" + " e Chassi: " + decolagem.fila1.get(0).getIdentification() + " Na Fila 1" + "\u001B[0m");
					decolagem.fila1.remove(0);
				} 
				if (decolagem.fila2.size() >= 1) {
					System.out.println("\u001B[31mAvião decolado com ID [" + decolagem.fila2.get(0).getId() + "]" + " e Chassi: " + decolagem.fila2.get(0).getIdentification() + " Na Fila 2" + "\u001B[0m");
					decolagem.fila2.remove(0);
				}
			} catch (Exception e) {
				System.out.println("Erro ao Organizar");
			}
		} else {
			entrada = 0;
		}
		if(A.getFila1().size()>0 && A.getFila2().size()>0 && this.getFila1().size()>0 && this.getFila2().size()>0) {
		int num1 = A.getFila1().get(0).getId();
		int num2 = A.getFila2().get(0).getId();
		int num3 = this.getFila1().get(0).getId();
		int num4 = this.getFila2().get(0).getId();
		int maior;
		if (num1 >= num2 && num1 >= num3 && num1 >= num4) {
            maior = num1;
            decolagem.inserirA(A.getFila2().get(0));
            decolagem.inserirA(this.getFila1().get(0));
            decolagem.inserirA(this.getFila2().get(0));
            A.getFila2().remove(0);
            this.getFila1().remove(0);
            this.getFila2().remove(0);
        } else if (num2 >= num1 && num2 >= num3 && num2 >= num4) {
            maior = num2;
            decolagem.inserirA(A.getFila1().get(0));
            decolagem.inserirA(this.getFila1().get(0));
            decolagem.inserirA(this.getFila2().get(0));
            A.getFila1().remove(0);
            this.getFila1().remove(0);
            this.getFila2().remove(0);
        } else if (num3 >= num1 && num3 >= num2 && num3 >= num4) {
            maior = num3;
            decolagem.inserirA(A.getFila2().get(0));
            decolagem.inserirA(A.getFila1().get(0));
            decolagem.inserirA(this.getFila2().get(0));
            A.getFila2().remove(0);
            A.getFila1().remove(0);
            this.getFila2().remove(0);
        } else {
            maior = num4;
            decolagem.inserirA(A.getFila2().get(0));
            decolagem.inserirA(A.getFila1().get(0));
            decolagem.inserirA(this.getFila1().get(0));
            A.getFila2().remove(0);
            A.getFila1().remove(0);
            this.getFila1().remove(0);
        }	
	}
}
	public void decrementar() {
		//decrementara a quantidade de combustivel
		for(int a=0;this.fila1.size()>a;a++) {
			int id = this.fila1.get(a).getId();
			id--;
			this.fila1.get(a).setId(id); 
		}
		for(int a=0;this.fila2.size()>a;a++) {
			int id = this.fila2.get(a).getId();
			id--;
			this.fila2.get(a).setId(id); 
		}
	}
	public void tempoMedioFila() {
		float soma=0;
		for(int a=0;this.fila1.size()>a;a++) {
			soma+=this.fila1.get(a).getId();
		}
		soma /= this.fila1.size();
		System.out.println("{ TEMPO MEDIO DA FILA UM } -> " + soma);
		soma=0;
		for(int a=0;this.fila2.size()>a;a++) {
			soma+=this.fila2.get(a).getId();
		}
		soma /= this.fila2.size();
		System.out.println("{ TEMPO MEDIO DA FILA DOIS } -> " + soma);
	}
}
