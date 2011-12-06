package com.pillingerphotography.katas;
import java.util.ArrayList;
import java.util.List;


public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();
		values.add(5);
		values.add(7);
		values.add(9);
		values.add(8);
		values.add(3);
		values.add(4);
		values.add(6);
		values.add(2);
		values.add(1);
		List<Integer> sorted= quicksort(values);
		for (int i : sorted) {
			System.out.println(i);
		}
	}

	public static List<Integer> quicksort(List<Integer> values) {
		if (values.size() <= 1)
		{
			return values;
		}
		
		int pivotIndex = values.size()/2;
		int pivot = values.remove(pivotIndex);
		
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();
		
		for (int value : values) {
			if (value <= pivot)
			{
				less.add(value);
			}
			else
			{
				greater.add(value);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(quicksort(less));
		result.add(pivot);
		result.addAll(quicksort(greater));
		return result;
	}

}
