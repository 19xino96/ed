package org.institutoserpis.ed;

import java.util.Random;
import java.util.Scanner;

public class Estadistica {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str;
		boolean ctrl = false;
		do {
			System.out.print("Introduzca el tamaño del vector: ");
			str = input.next();
			if (str.matches("\\d+")) {
				ctrl = true;
			}
		} while (!ctrl);
		int[] vctr = generarVector(Integer.parseInt(str));
		
		System.out.println("\nVector: " + vectorToString(vctr));
		System.out.println("\nValor máximo: " + valorMaximo(vctr)[0]
				+ " (índice: " + valorMaximo(vctr)[1] + ")");
		System.out.println("Valor mínimo: " + valorMinimo(vctr)[0]
				+ " (índice: " + valorMinimo(vctr)[1] + ")");
		System.out.println("Valor medio: " + valorMedio(vctr));
	}

	/*
	 * Genera un vector del tamaño indicado y lo rellena con números
	 * aleatorios (valores del 1 al 10)
	 */
	public static int[] generarVector(int size) {	
		int[] vctr = new int[size];
		Random rgn = new Random();
		for (int i=0; i<size; i++) {
			vctr[i] = rgn.nextInt(10)+1;
		}
		return vctr;
	}
	
	/*
	 * Indica el valor máximo dentro de un vector y en qué índice se encuentra
	 * el primer elemento con ese valor. Devuelve un vector de 2 elementos donde el 
	 * primero indica el valor máxmio y el segundo indica el índice.
	 */
	public static int[] valorMaximo(int[] vctr) {
		int max = vctr[0];
		int i = 0;
		for (int j=1; j<vctr.length; j++) {
			if (vctr[j] > max) {
				max = vctr [j];
				i = j;
			}
		}
		return new int[]{max, i};
	}
	
	/*
	 * Indica el valor mínimo dentro de un vector y en qué índice se encuentra
	 * el primer elemento con ese valor. Devuelve un vector de 2 elementos donde el 
	 * primero indica el valor mínimo y el segundo indica el índice.
	 */
	public static int[] valorMinimo(int[] vctr) {
		int min = vctr[0];
		int i = 0;
		for (int j=1; j<vctr.length; j++) {
			if (vctr[j] < min) {
				min = vctr [j];
				i = j;
			}
		}
		return new int[]{min, i};
	}
	
	/*
	 * Indica el valor medio obtenido de los elementos de un vector
	 */
	public static double valorMedio(int[] vctr) {
		double sum = 0;
		for (int i=0; i<vctr.length; i++) {
			sum += vctr[i];
		}
		return sum/vctr.length;
	}
	
	/*
	 * Devuelve una cadena que lista los elementos del vector que se introduce como parámetro
	 */
	public static String vectorToString(int[] vctr) {
		String str = "";
		str = str.concat("{" + vctr[0]);
		for (int i=1; i<vctr.length; i++) {
			str = str.concat("," + vctr[i]);
		}
		str = str.concat("}");
		return str;
	}
}
