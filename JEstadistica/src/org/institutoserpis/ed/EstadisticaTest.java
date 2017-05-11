package org.institutoserpis.ed;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstadisticaTest {

	@Test
	public void generarVector() {
		int[] vctr;
		
		//int[5]
		vctr = Estadistica.generarVector(5);
		assertEquals(5, vctr.length); //Comprueba longitud vector
		for (int i=0; i<5; i++) { 
		//Comprueba que los valores se encuentren entre 1 y 10
			assertTrue(1 <= vctr[i] && vctr[i] <= 10);
		}
		
		//int[4]
		vctr = Estadistica.generarVector(4);
		assertEquals(4, vctr.length);
		for (int i=0; i<4; i++) { 
			assertTrue(1 <= vctr[i] && vctr[i] <= 10);
		}
		
		//int[1]
		vctr = Estadistica.generarVector(1);
		assertEquals(1, vctr.length);
		for (int i=0; i<1; i++) { 
			assertTrue(1 <= vctr[i] && vctr[i] <= 10);
		}
		
		//int[15]
		vctr = Estadistica.generarVector(15);
		assertEquals(15, vctr.length);
		for (int i=0; i<15; i++) { 
			assertTrue(1 <= vctr[i] && vctr[i] <= 10);
		}
		
		//int[0]
		vctr = Estadistica.generarVector(0);
		assertEquals(0, vctr.length);
	}
	
	@Test
	public void valorMaximo() {
		int[] vctr;
		
		//inicio
		vctr = new int[]{10,8,5,2,7};
		assertEquals(10, Estadistica.valorMaximo(vctr)[0]); //Comprueba max. valor
		assertEquals(0, Estadistica.valorMaximo(vctr)[1]); //Comprueba índice max. valor
		
		//final
		vctr = new int[]{3,8,5,2,10};
		assertEquals(10, Estadistica.valorMaximo(vctr)[0]);
		assertEquals(4, Estadistica.valorMaximo(vctr)[1]);
		
		//en medio
		vctr = new int[]{3,8,10,2,7};
		assertEquals(10, Estadistica.valorMaximo(vctr)[0]);
		assertEquals(2, Estadistica.valorMaximo(vctr)[1]);
		
		//repetido
		vctr = new int[]{10,8,10,2,10};
		assertEquals(10, Estadistica.valorMaximo(vctr)[0]);
		assertEquals(0, Estadistica.valorMaximo(vctr)[1]);
		
		//un elemento
		vctr = new int[]{5};
		assertEquals(5, Estadistica.valorMaximo(vctr)[0]);
		assertEquals(0, Estadistica.valorMaximo(vctr)[1]);
	}
	
	@Test
	public void valorMinimo() {
		int[] vctr;
		
		//inicio
		vctr = new int[]{1,8,5,2,7};
		assertEquals(1, Estadistica.valorMinimo(vctr)[0]); //Comprueba min. valor
		assertEquals(0, Estadistica.valorMinimo(vctr)[1]); //Comprueba índice min. valor
		
		//final
		vctr = new int[]{3,8,5,2,1};
		assertEquals(1, Estadistica.valorMinimo(vctr)[0]);
		assertEquals(4, Estadistica.valorMinimo(vctr)[1]);
		
		//en medio
		vctr = new int[]{3,8,1,2,7};
		assertEquals(1, Estadistica.valorMinimo(vctr)[0]);
		assertEquals(2, Estadistica.valorMinimo(vctr)[1]);
		
		//repetido
		vctr = new int[]{1,8,1,2,1};
		assertEquals(1, Estadistica.valorMinimo(vctr)[0]);
		assertEquals(0, Estadistica.valorMinimo(vctr)[1]);
		
		//un elemento
		vctr = new int[]{5};
		assertEquals(5, Estadistica.valorMinimo(vctr)[0]);
		assertEquals(0, Estadistica.valorMinimo(vctr)[1]);
	}
	
	@Test
	public void valorMedio() {
		//numero entero
		assertEquals(5, Estadistica.valorMedio(new int[]{3,8,5,2,7}), 0.00001);
		//numero con decimales
		assertEquals(6.4, Estadistica.valorMedio(new int[]{10,8,5,2,7}), 0.00001);
		//vector con solo un elemento
		assertEquals(3, Estadistica.valorMedio(new int[]{3}), 0.00001);
	}
}
