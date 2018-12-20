package com.dataStr;

public class BinarySearch {
	public static int binarySearch(int[] A, int x)
	{
		// search space is A[left..right]
		int left = 0, right = A.length - 1;
		// till search space consists of at-least one element
		while (left <= right){
			// we find the mid value in the search space and compares it with key value
			int mid = left + (right - left) / 2;
			if (x == A[mid]) {
				return mid;
			}
			// discard all elements in the right search space including the mid element
			else if (x < A[mid]) {
				right = mid - 1;
			}
			// discard all elements in the left search space including the mid element
			else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		int[] A = { 2, 5, 6, 8, 9, 10 };
		int key = 2;
		int index = binarySearch(A, key);
		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found in the array");
		}
	}
}
