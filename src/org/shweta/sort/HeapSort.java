package org.shweta.sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = {5, 1, 6, 2, 4, 3};
		
		HeapSort hSort = new HeapSort();
		System.out.println("Given Array is ::: ");
		hSort.printArray(array);
		hSort.heapSort(array);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		hSort.printArray(array);
	}
	
	public void heapSort(int[] array){
		for(int i=array.length/2 ; i >= 0; i--){
			maxHeapify(array, i);
		}
	}
	
	public void maxHeapify(int[] array, int i){
		int l = 2*i;
		int r = (2*i) + 1;
		int largest;
		int heapSize = array.length - 1;
		if(l<=heapSize && array[l] > array[i])
			largest = l;
		else
			largest = i;
		if(r<=heapSize && array[r] > array[largest])
			largest = r;
		if(largest!=i){
			swap(array, i, largest);
			maxHeapify(array, largest);
		}
	}
	
	public void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}
	
	private void swap (int A[], int x, int y)
	{
	      int temp = A[x];
	      A[x] = A[y];
	      A[y] = temp;
	}

}
