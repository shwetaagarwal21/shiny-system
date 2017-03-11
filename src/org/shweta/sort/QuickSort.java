package org.shweta.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {5, 1, 6, 2, 4, 3};
		
		QuickSort qSort = new QuickSort();
		System.out.println("Given Array is ::: ");
		qSort.printArray(array);
		qSort.quickSort(array, 0, array.length - 1);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		qSort.printArray(array);

	}
	
	private void quickSort(int[] array, int p, int r){
		if(p<r)
		{
			int q = partition(array, p, r);
			//System.out.println("q is :: " + q);
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);
		}
	}
	
	private int partition(int[] array, int p, int r){
		int x = array[r];
		int i = p - 1;
		for(int j= p; j<r; j++)
		{
			if(array[j] <= x)
			{	
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, r);
		return (i+1);
	}
	
	private void swap (int A[], int x, int y)
	{
	      int temp = A[x];
	      A[x] = A[y];
	      A[y] = temp;
	}
	
	private void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}

}
