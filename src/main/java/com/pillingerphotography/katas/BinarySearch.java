package com.pillingerphotography.katas;
import java.util.Arrays;


public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = new int[]{1,2,3,4,5,6,7,8,20,21,43};
		
		int i = findIndex(20,values, 0);
		System.out.println(i + ":" + values[i]);
		i = findIndex(2,values, 0);
		System.out.println(i + ":" + values[i]);
		i = findIndex(99,values, 0);
		System.out.println(i + ":" + values[i]);

	}

	private static int findIndex(int i, int[] values, int pos) {
		int mid = values.length/2;
		int val = values[mid];
		if (val == i)
		{
			return pos+mid;
		}
		else if (values.length == 1)
		{
			return -1;
		}
		else if (val > i)
		{
			return findIndex(i, Arrays.copyOfRange(values, 0, mid), pos);
		}
		else
		{
			return findIndex(i, Arrays.copyOfRange(values, mid, values.length), pos+mid);
		}
	}

}
