import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {
    //Testing 1
	//Testing 2
	public static void main(String[] args) {
		Test tt = new Test();
		int A[] = {4,6,7,7,7,9,9};
		int target = 7;
		//int[] out = tt.findFirstAndLastOccurence(A, target);
		int[] out = tt.findFirstAndLastOccurenceBinarySearch(A, target);
		
		/*for(int i = 0; i < output.length; i++){
			System.out.print(output[i] + " ");
		}*/
		
		for(int i = 0; i < out.length; i++){
			System.out.print(out[i] + " ");
		}
		
		String str = "Infosys";
		tt.getNumberOfOccurences(str);
		
		int input[] = {1, 3, 1, 4, 6, 1, 2, 6};
		HashMap<Integer, Integer> occMap = tt.getOccurence(input);
		System.out.println("Map has ");
		System.out.println(occMap.entrySet());
		
		int A2[] = {1, 4, 3, 6, 7, 5, 2 };
		int target2 = 8;
		int output[] = new int[2];
		Map<Integer, Integer> hMap = new HashMap<>();
		for(int i=0;i<A2.length;i++){
			if(hMap.containsKey(A2[i])){
				int val = hMap.get(A2[i]);
				//output[0] = val;
				//output[1] = i;
				//break;
				System.out.println(val + "    " + i);
			}else{
				hMap.put(target2 - A2[i], i);
			}
		}
		
		System.out.println("output[0] is " + output[0]);
		System.out.println("output[1] is " + output[1]);
		
		int array[] = {1, 4, 3, 6, 7, 7, 1 };
		int unique[] = removeDuplicates(array, array.length);
		System.out.println("Unique elements in array are :: ");
		System.out.println(Arrays.toString(unique));
		
		int A3[] = {1,2,4,1,4,1,1,4,1};
		HashMap<Integer, Integer> dupCountMap = findDuplicatesCount(A3);
		System.out.println("Duplicate Counts in Map are :: ");
		for( Map.Entry<Integer, Integer> e: dupCountMap.entrySet()){
			if(e.getValue() > 1){
				System.out.println(e.getKey() + " : " + e.getValue());
			}
		}
		
	}
	
	static HashMap<Integer, Integer> findDuplicatesCount(int[] arr){
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++){
			if(!hMap.containsKey(arr[i])){
				hMap.put(arr[i], 1);
			}else{
				hMap.put(arr[i], hMap.get(arr[i]) + 1);
			}
		}
		return hMap;
	}
	
	static int[] removeDuplicates(int[] arr, int n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i] == arr[j]){
					arr[j] = arr[n-1];
					n--;
					j--;
				}
			}
		}
		return Arrays.copyOf(arr, n);
	}
	
	HashMap<Integer, Integer> getOccurence(int[] input){
		HashMap<Integer, Integer> hMap = new HashMap<>();
		for(int i=0;i<input.length;i++){
			if(hMap.containsKey(input[i])){
				int val = hMap.get(input[i]);
				hMap.put(input[i], val + 1);
			}else{
				hMap.put(input[i], 1);
			}
		}
		return hMap;	
	}
	
	void getNumberOfOccurences(String str){
		char[] charArray = str.toCharArray();
		HashMap<Character, Integer> hMap = new HashMap<>();
		for(int i=0;i<charArray.length;i++){
			if(hMap.containsKey(charArray[i])){
				int val = hMap.get(charArray[i]);
				hMap.put(charArray[i], val + 1);
			}else
				hMap.put(charArray[i], 1);
		}
		System.out.println("Map has ");
		System.out.println(hMap.entrySet());
	}
	
	int[] findFirstAndLastOccurenceBinarySearch(int[] A, int target){
		int index = first(A, target, 0, A.length - 1);
		int out[] = new int[2];
		out[0] = index;
		out[1] = last(A, target, 0, A.length - 1);
		return out;
	}
	
	public int first(int[] array, int key, int start, int end){
		if(start > end) return -1;
		double middle = Math.floor(((start + end)/2));
		
		if( (middle == 0 || key > array[(int)middle-1]) && key == array[(int)middle] )
			return (int)middle;
		if(key > array[(int)middle])
			return first(array, key, (int)middle + 1, end);			
		else
			return first(array, key, start, (int)middle - 1);		
	}
	
	public int last(int[] array, int key, int start, int end){
		if(start > end) return -1;
		double middle = Math.floor(((start + end)/2));
		System.out.println("Middle is :: " + middle);
		System.out.println("Start is :: " + start + " end is :: "+ end);
		
		if((middle == array[end] || key < array[(int)middle+1]) && array[(int)middle] == key)
			return (int)middle;
		else if(key < array[(int)middle])
			return last(array, key, start, (int)middle - 1);
		else
			return last(array, key, (int)middle + 1, end);
		
	}
	
	int[] findFirstAndLastOccurence(int[] A, int target){
	    int length = A.length;
	    int output[] = new int[2];
	    int j = 0;
	    int i;
	    for(i=0; i<length; i++){
	         if(A[i] == target){
	             output[j] = i;
	             break;             
	         }         
	    }
	    //i = 2
	    while((A[i] ^ A[i+1]) == 0){
	        i = i+1;
	    }
	    j = j + 1;
	    output[j] = i;   
	    return output;
	}

}
