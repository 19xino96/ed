package org.institutoserpis.ed;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector2Test {

	@Test
	public void IndexOf() {
		assertEquals(0, Vector2.indexOf(new int[]{32, 15, 7, 9,  12}, 32));
		assertEquals(2, Vector2.indexOf(new int[]{32, 15, 7, 9,  12}, 7));
		assertEquals(3, Vector2.indexOf(new int[]{32, 15, 7, 9,  12}, 9));
		assertEquals(4, Vector2.indexOf(new int[]{32, 15, 7, 9,  12}, 12));
		assertEquals(-1, Vector2.indexOf(new int[]{32, 15, 7, 9,  12}, 99));
	}
	
	@Test
	public void IndexOfEmpty() {
		assertEquals(-1, Vector2.indexOf(new int[]{}, 123));
	}
	
	@Test
	public void min() {
		assertEquals(3, Vector2.min(new int[]{3, 15, 7, 9, 12}));
		assertEquals(3, Vector2.min(new int[]{32, 15, 7, 9, 12}));
		assertEquals(3, Vector2.min(new int[]{32, 15, 7, 9, 2}));
	}
	
	@Test
	public void selectionSort() {
		int[] vct = new int[]{32, 15, 7, 9, 12};
		Vector2.selectionSort(vct);
		assertArrayEquals(new int[]{7, 9, 12, 15, 32}, vct);
		
		vct = new int[]{32, 7, 15, 9, 12};
		Vector2.selectionSort(vct);
		assertArrayEquals(new int[]{7, 9, 12, 15, 32}, vct);
		
		vct = new int[]{32, 15, 12, 9, 7};
		Vector2.selectionSort(vct);
		assertArrayEquals(new int[]{7, 9, 12, 15, 32}, vct);
	}
}
