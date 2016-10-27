package org.institutoserpis.ed;

import java.util.Random;
import java.util.Scanner;

public class Adivina {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		int numeroAleatorio = random.nextInt(1000) + 1;
		System.out.println("numeroAleatorio = " + numeroAleatorio);
		System.out.println("Tengo esconio un número entre 1 y 1000. Adivina...");
		
//		do {
//			System.out.println("Estoy pensando un número secreto entre 1 y 1000, adivina cúal:");
//			resp = input.next();
//			System.out.println();
//		} while (Double.parseDouble(resp)%1 != 0 || Integer.parseInt(resp)>1000 || Integer.parseInt(resp)<1);
//		inputNum = Integer.parseInt(resp);
		
		int contador = 0;
		boolean correcto;
		do {
			contador++;
			System.out.println();
			System.out.println("(Intento: " + contador + ")");
			System.out.print("Introduce el número: ");
			String resp = input.nextLine();
			int inputNum = Integer.parseInt(resp);
			if (inputNum < numeroAleatorio) 
				System.out.println("El número secreto es mayor");
			if (inputNum > numeroAleatorio)
				System.out.println("El número secreto es menor");
			correcto = inputNum == numeroAleatorio;
		} while (!correcto);
		System.out.println();
		System.out.println("¡Correcto! Has adivinado el número secreto.");
		System.out.println("Número de intentos: " + contador);
	}
	
}
