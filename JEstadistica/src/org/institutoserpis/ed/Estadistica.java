package org.institutoserpis.ed;

import java.util.Random;

public class Estadistica {
	
	public static void main(String[] args) {
		
	}

	/**
	 * Genera un vector del tamaño indicado y lo rellena con números
	 * aleatorios (valores del 1 al 10)
	 * @param size La longitud del vector
	 * @return El vector
	 */
	public static int[] generarVector(int size) {	
		int[] vctr = new int[size];
		Random rgn = new Random();
		for (int i=0; i<size; i++) {
			vctr[i] = rgn.nextInt(10)+1;
		}
		return vctr;
	}
	
	/**
	 * Indica el valor máximo dentro de un vector y en qué índice se encuentra
	 * el primer elemento con ese valor
	 * @param vctr El vector
	 * @return Vector de 2 elementos donde el primero indica el valor máximo y el segundo indica el índice
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
	
	/**
	 * Indica el valor mínimo dentro de un vector y en qué índice se encuentra
	 * el primer elemento con ese valor
	 * @param vctr El vector
	 * @return Vector de 2 elementos donde el primero indica el valor mínimo y el segundo indica el índice
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
	
	/**
	 * Indica el valor medio obtenido de los elementos de un vector
	 * @param vctr El vector
	 * @return Valor medio
	 */
	public static double valorMedio(int[] vctr) {
		double sum = 0;
		for (int i=0; i<vctr.length; i++) {
			sum += vctr[i];
		}
		return sum/vctr.length;
	}
}
