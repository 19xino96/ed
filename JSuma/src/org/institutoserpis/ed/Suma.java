package org.institutoserpis.ed;

import java.util.Scanner;
import java.math.BigDecimal;

public class Suma {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Programa suma:");
		System.out.print("Introduce el primer número: ");		
		String strPrimerNumero = input.nextLine();
		BigDecimal primerNumero = new BigDecimal(strPrimerNumero);
		System.out.println("Ahora introduce el segundo número: ");
		String strSegundoNumero = input.nextLine();
		BigDecimal segundoNumero = new BigDecimal(strSegundoNumero);
//		BigDecimal suma = new BigDecimal(0);
		BigDecimal suma = BigDecimal.ZERO;
//		primerNumero.add(segundoNumero);   no funciona por que no cambia el valor de la variable
		suma = suma.add(primerNumero).add(segundoNumero);
		System.out.println("La suma es " + suma);
//		System.out.println("La suma es " + primerNumero.add(segundoNumero); aquí sí funciona
	}

} 
