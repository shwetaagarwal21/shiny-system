package org.shweta.arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	final static int INVALID_NUM = 0;
	
	public static void main(String[] args) {
		int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 12, INVALID_NUM};
		int[] arrayB = {-1, 2, 6, 11};
		MergeTwoSortedArrays sol = new MergeTwoSortedArrays();
		sol.mergeArrays(arrayA, arrayB);
		System.out.println(Arrays.toString(arrayA));		
	}
	
	void mergeArrays(int[] arr1, int[] arr2){
		int index = arr1.length - 1;
		for(int i = arr1.length - 1; i>= 0; i--){
			if(arr1[i]!=INVALID_NUM){
				arr1[index] = arr1[i];
				index--;
			}
		}
		
		int i = index+1;
		int j = 0;
		int k = 0;
		while(i<arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				arr1[k] = arr1[i];
				i++;
				k++;
			}else{
				arr1[k] = arr2[j];
				j++;
				k++;
			}
		}
		
		while(j<arr2.length){
			arr1[k] = arr2[j];
			j++;
			k++;
		}
		
		/*while(i<arr1.length){
			arr1[k] = arr1[i];
			i++;
			k++;
		}*/		
	}

}
