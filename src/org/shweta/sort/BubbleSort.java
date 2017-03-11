package org.shweta.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {5, 1, 6, 2, 4, 3};
		
		BubbleSort bSort = new BubbleSort();
		System.out.println("Given Array is ::: ");
		bSort.printArray(array);
		bSort.bubbleSort(array);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		bSort.printArray(array);
	}
	
	private void bubbleSort(int[] array){
		//int length = array.length;
		int temp;
		for(int i = 0; i <array.length ; i++){
			for(int j=1;j< array.length - i;j++){
				if(array[j-1] > array[j]){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	public void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}
	
	
}

