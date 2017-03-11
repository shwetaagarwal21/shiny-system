package org.shweta.search;

public class BinarySearch {
	
	public static void main(String args[]){
		int[] array = {2, 4, 7, 9, 13, 15};
		
		BinarySearch search = new BinarySearch();
		double index = search.binarySearch(array, 13, 0, array.length - 1);
		System.out.println("Index of 13 is " + (int)index);
	}
	
	public double binarySearch(int[] array, int key, int start, int end){
		if(start > end) return -1;
		double middle = Math.floor(((start + end)/2));
		if(key == array[(int)middle])
			return (int)middle;
		if(key > array[(int)middle])
			return binarySearch(array, key, (int)middle + 1, array.length - 1);			
		else
			return binarySearch(array, key, start, (int)middle - 1);
		
	}
	
}
