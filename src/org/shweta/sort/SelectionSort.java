package org.shweta.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {10,34,2,56,7,67,88,42};
		
		SelectionSort sSort = new SelectionSort();
		System.out.println("Given Array is ::: ");
		sSort.printArray(array);
		sSort.selectionSort(array);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		sSort.printArray(array);
	}
	
	private void selectionSort(int[] arr){
		for (int i = 0; i < arr.length - 1; i++)
	    {
	        int index = i;
	        for (int j = i + 1; j < arr.length; j++)
	            if (arr[j] < arr[index]) 
	                index = j;
	  
	        int smallerNumber = arr[index];  
	        arr[index] = arr[i];
	        arr[i] = smallerNumber;
	    }
	}
	
	
	public void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}

}
