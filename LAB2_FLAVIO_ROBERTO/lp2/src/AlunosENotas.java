
/**
* Laboratorio de Programacao 2 - Lab 1
*
* @author Flavio Farias - 117111444
*/

import java.util.Scanner;

public class AlunosENotas{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int maiornota = 0;
		int menornota = Integer.MAX_VALUE;
		float media = 0;
		int aprovados = 0;
		int reprovados = 0;
		int soma = 0;
		int acima = 0;
		int abaixo = 0;
		
		String[] dados = new String[2];
		String entrada = sc.nextLine(); 

		while (!dados[0].equals("-")){
		entrada = sc.nextLine(); 
		dados = entrada.split(" ");
		int dadosint = Integer.parseInt(dados[1]);
		if (dadosint > maiornota) {
			maiornota = Integer.parseInt(dados[1]);
		}
		if (dadosint < menornota) {
			menornota = Integer.parseInt(dados[1]);
		}
		if (dadosint < 700) {
			abaixo++;
		}else {
			acima++;
		}
		
		soma += dadosint;
		
		}
		System.out.println(maiornota + menornota + acima + abaixo);
	}		
	}


