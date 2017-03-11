package org.shweta.sort;

public class MergeSort {
	
	private int[] helper;
	
	public static void main(String[] args) {
		int[] array = {9, 6, 5, 0, 8, 2, 4, 7};//{5, 1, 6, 2, 4, 3};{6, 8, 4};
		
		MergeSort mSort = new MergeSort();
		System.out.println("Given Array is ::: ");
		mSort.printArray(array);
		mSort.mergeSort(array, 0, array.length - 1);
		System.out.println();
		System.out.println("Sorted Array is ::: ");
		mSort.printArray(array);
	}
	
	private void mergeSort(int[] array, int p, int r){
		int q;
		int length = array.length;
		this.helper = new int[length];
		if(p < r){
			q = p + (r - p)/2; 
			/*System.out.println();
			System.out.println("p is " + p + " q is " + q + " r is " + r );
			System.out.println("Calling mergeSort with (A, p, q) as (A, " + p + ", " + q + ")");*/
			mergeSort(array, p, q);
			//System.out.println("Calling mergeSort with (A, q+1, r) as (A, " + (q+1) + ", " + r + ")");
			mergeSort(array, q + 1, r);
			System.out.println("Calling merge with (A, p, q, r) as (A, " + p + ", "+ q + ", " + r + ")");
			merge(array, p, q, r);
		}
	}
	
	/*private void merge(int[] array, int p, int q, int r){
		int n1, n2;
		n1 = q - p + 1;
		n2 = r - q;
		System.out.println("p:: " + p + " q:: " + q + " r:: " + r + " n1:: " + n1 + " n2:: " + n2);
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0;i<n1;i++)
			L[i] = array[p+i - 1];
		for(int j=0;j<n2;j++)
			R[j] = array[q+j];
		L[n1] = 9999;
		R[n2] = 9999;
		System.out.println("Array L is :: ");
		printArray(L);
		System.out.println();
		System.out.println("Array R is :: ");
		printArray(R);
		System.out.println();
		int i = 0, j = 0;
		for(int k = p; k< r; k++){
			if(L[i] <= R[j]){
				array[k] = L[i];
				i++;
			}else{
				array[k] = R[j];
				j++;
			}
			System.out.println("array[k] is " + array[k] + " and k is :: " + k);
		}
	}*/
	
	private void merge(int[] array, int p, int q, int r){
		
		for (int i = p; i <= r; i++) {
            helper[i] = array[i];
		}
		int i = p;
        int j = q + 1;
        int k = p;
        
        while (i <= q && j <= r) {
            if (helper[i] <= helper[j]) {
                    array[k] = helper[i];
                    i++;
            } else {
            		array[k] = helper[j];
                    j++;
            }
            k++;
        }
        
        while (i <= q) {
        	array[k] = helper[i];
            k++;
            i++;
        }
        
	}

	
	private void printArray(int[] array){
		for(int i: array){
			System.out.print(i + " ");
		}
	}

}
