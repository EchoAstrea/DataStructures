
/*
 * Tessa Dalbo
 * Program 8
 * due 12/04/2025
 * 
 * This program sorts an array using bottom-up merge sort. It starts by merging pairs, 
 * then groups of 4, then 8, etc. until everything is sorted.
 */

 package programs;

import java.util.ArrayList;
import java.util.Arrays;

public class BottomUpMergeSort {
	
	
	public static ArrayList<Integer> merge(int[] left, int[] right){
		ArrayList<Integer> result= new ArrayList<>();
		int index1=0; 
		int index2=0; 
		
		while(index1<left.length && index2<right.length) {
			if(left[index1]<right[index2]) {
				result.add(left[index1]);
				index1++;
			}
			else if(left[index1]>right[index2]) {
				result.add(right[index2]);
				index2++;
			}
			else if(left[index1]==right[index2]) {
				result.add(left[index1]);
				index1++;
			}
			
		}
		while(index1<left.length) {
			result.add(left[index1]);
			index1++;
		}
		while(index2<right.length) {
			result.add(right[index2]);
			index2++;
		}
		
		return result;
		
	}
	
	public static void mergeSort(int[] arr) {
		int size=1; 
		while(size<arr.length) {
			for(int i=0; i<arr.length; i+=size*2) {
				int leftSize=Math.min(size, arr.length-i);
				int[] left= new int[leftSize];
				for(int j=0; j<leftSize; j++) {
					left[j]= arr[i+j];
				}
				int rightSize=Math.min(size, arr.length-(i+leftSize));
				int[] right= new int[rightSize];
				for(int k=0; k<rightSize; k++) {
					right[k]= arr[i+leftSize+k];
				}
				ArrayList<Integer> merged=merge(left,right);
				
				for(int m=0; m<merged.size(); m++) {
					arr[i+m]=merged.get(m);
				}	
				
			}
			System.out.println("Pass "+size+": "+Arrays.toString(arr));
			size*=2;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {9,8,7,6,5,4,3,2,1};
	    
	    System.out.println("Before: " + Arrays.toString(test));
	    mergeSort(test);
	    System.out.println("After: " + Arrays.toString(test));


	}

}
