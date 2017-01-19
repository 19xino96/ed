package org.institutoserpis.ed;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class VectorTest {

	@Test
	public void testIndexOf() {
		//no borro tests, voy añadiendolos uno a uno
		
		int[] v = new int[]{32, 15, 7, 9, 12};
		int item = 9;
		
		int index = Vector.indexOf(v, item);
		Assert.assertEquals(3, index);
		
	}

}
