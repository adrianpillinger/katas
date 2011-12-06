package com.pillingerphotography.katas;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = new int[]{5,7,9,8,3,4,6,2,1};
		
		boolean swapped = false;
		do {
			swapped = sortPass(values);
		} while (swapped);
		
		for (int i : values) {
			System.out.println(i);
		}

	}

	public static boolean sortPass(int[] values) {
		boolean swapped = false;
		for(int i = 0; i < values.length -1; i++)
		{
			int a = values[i];
			int b = values[i+1];
			if (a > b)
			{
				values[i] = b;
				values[i+1] = a;
				swapped = true;
			}
		}
		return swapped;
	}

}
