package org.shweta.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = {5, 1, 6, 2, 4, 3};
		
		InsertionSort iSort = new InsertionSort();
		System.out.println("Given Array is ::: ");
		iSort.printArray(array);
		iSort.insertionSort(array);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		iSort.printArray(array);

	}
	
	private void insertionSort(int[] array){
		int key;
		int j;
		for(int i=1;i<array.length;i++){
			key = array[i];
			//insert A[i] into sorted sequence A[1... i-1]
			j = i-1;
			while(j>=0 && array[j] > key){
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}

	private void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}
	
}
