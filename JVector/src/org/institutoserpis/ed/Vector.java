package org.institutoserpis.ed;

import java.util.Random;

public class Vector {

	public static void main(String[] args) {
		
//		int index = 0;
//		
//		while (index < 5) {
//			
//			System.out.println("index = " + index);
//			index++;
//		}
		
//		for(;;) == while(true)
		int[] v = new int[]{32,15, 7, 9, 12};
//		Random random = new Random();
//		int[] v = new int[100];
		for(int index = 0 /*index no existe fuera del ciclo. Bueno, sí, pero se oculta*/; index < v.length; index ++) {
//			v[index] = random.nextInt(1000) + 1;
			System.out.println("v[" + index + "] = " + v[index]);
		}
		System.out.println("indexOf=" + indexOf2(v, 9)/*lo primero que se mira es el resultado de la operción. Como es un 
		+ podría ser ser una suma o una concatenación. Primero se mira lo de la izquierda, siempre. Es una cadena,
		por eso concatenacion*/);
	}
	
	//busqueda(cuando lo encuentro, paro) vs recorrido(recorro todo el vector)
	public static int indexOf(int[] v, int item) {
		
		for(int i=0; i<v.length; i++) 
			
			if (v[i] == item)
				return i;
		
		return -1;
	}
	
	public static int indexOf2(int[] v, int item) {
		
		int index = 0;
		while (index<v.length && v[index]!=item) // a and b --> se comprueba primero el a, si lo pusieramos al reves
												// daría error si no encuentra el item.
			
			index++;
		if (index == v.length)
			
			return -1;
		return index;
	}
	
	
	
	
	
//	public static int indexOf1(int[] v, int item) {
//		
//		while (true) {
////			int x = 0;
////			int i = 0;
////			i = i + v.length/x;
////			x += 2;
//			
//			int x = 0;
//			for(int i=0; i<v.length/2; i+v.length/x) {
//				
//				if (v[i] == item)
//					return i;
//			}
//		}
//		return -1;
//	}
	
}
   	