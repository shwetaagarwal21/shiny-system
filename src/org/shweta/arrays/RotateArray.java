package org.shweta.arrays;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 8;
		System.out.println("Original Array:: " + Arrays.toString(arr));
		rotateArrayNaive(arr, k);
		System.out.println("After rotation array " + k + " times : " + Arrays.toString(arr));
		rotateArrayTempArray(arr, k);
		System.out.println("After rotation array using rotation array " + k + " times : " + Arrays.toString(arr));
		rotateArrayReverse(arr, k);
		System.out.println("After rotation array using reverse " + k + " times : " + Arrays.toString(arr));
	}
	
	static void rotateArrayNaive(int[] arr, int k){
		if(k<0)
			throw new IllegalArgumentException("k cannot be negative!");
		if(arr == null || arr.length < 2)
			return;
		if(k>arr.length)
			k = k%arr.length;
		for(int i=0;i<k;i++)
			rotateArrayOnce(arr);
	}
	
	static void rotateArrayOnce(int[] arr){
		int first = arr[0];
		for(int i=0;i<arr.length-1;i++){
			arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = first;
	}
	
	static void rotateArrayTempArray(int[] arr, int k){
		if(k<0)
			throw new IllegalArgumentException("k cannot be negative!");
		if(arr == null || arr.length < 2)
			return;
		if(k>arr.length)
			k = k%arr.length;
		int temp[] = new int[k];
		for(int i=0;i<k;i++)
			temp[i] = arr[i];
		int p = 0;
		for(int i=k;i<arr.length;i++){
			arr[p] = arr[i];
			p++;
		}
		
		int j = 0;
		for(int i=k-1;i<arr.length;i++){
			arr[i] = temp[j];
			j++;
		}
	}
	
	static void rotateArrayReverse(int[] arr, int k){
		if(k<0)
			throw new IllegalArgumentException("k cannot be negative!");
		if(arr == null || arr.length < 2)
			return;
		if(k>arr.length)
			k = k%arr.length;
		reverseArray(arr, 0, k-1);
		reverseArray(arr, k, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}
	
	static void reverseArray(int[] arr, int start, int end){
		int temp;
		while(start<end){
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
}
