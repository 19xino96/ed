package org.institutoserpis.ed;

public class Vector2 {

	public static void main(String[] args) {
		int index = indexOf(new int[]{32, 15, 7, 9, 12}, 99);
		System.out.println("Vector index=" + index);
	}
	
	public static int indexOf(int[] vct, int item) {
		int index = 0;
		while (index < vct.length && vct[index] != item)
			index++;
		if (index == vct.length)
			return -1;
		return index;
	}
	
	public static int min(int[] vct) {
		int min = vct[0];
		for (int item : vct)
			if (item < min)
				min = item;
		return min;
	}
	
	public static void selectionSortUgly(int[] vct) {	
		for (int itemIndex = 0; itemIndex < vct.length - 1; itemIndex++) {
			int indexOfMin = itemIndex;
			for (int index = itemIndex + 1; index < vct.length; index++)
				if (vct[index] < vct[indexOfMin])
					indexOfMin = index;
			int aux = vct[itemIndex];
			vct[itemIndex] = vct[indexOfMin];
			vct[indexOfMin] = aux;
		}
	}
	private static int indexOfMin(int[] vct, int initialIndex) {
		int indexOfMin = initialIndex;
		for (int index = initialIndex+1; index < vct.length; index++)
			if (vct[index] < vct[indexOfMin])
				indexOfMin = index;
		return indexOfMin;
	}
	private static void swap(int[] vct, int indexOne, int indexTwo) {
		int aux = vct[indexOne];
		vct[indexOne] = vct[indexTwo];
		vct[indexTwo] = aux;
	}
	public static void selectionSort(int[] vct) {	
		for (int itemIndex = 0; itemIndex < vct.length - 1; itemIndex++) {
			int indexOfMin = indexOfMin(vct, itemIndex);
			swap(vct, itemIndex, indexOfMin);
//			swap(vct, itemIndex, indexOfMin(vct, itemIndex));
		}
	}
	
}
