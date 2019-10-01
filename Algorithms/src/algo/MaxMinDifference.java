package algo;

import java.util.Arrays;

/**
 * 
 * Program to find the difference between Maximum and Minimum of given number of
 * elements and to find the minimum of the differences.
 * 
 * Ex: 10, 20, 40, 30, 15, 50, 60, 52, 80, 56, 45 // Grouping 3 elements
 * 
 * Output: max(50,52,56) - min(50,52,56) = 56 - 50 = 6
 * 
 * @author ndevara
 *
 */
public class MaxMinDifference {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 40, 30, 15, 50, 60, 52, 80, 56, 45 };
		// int[] arr = { 1, 2, 1, 2, 1 };
		// int[] arr = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};

		// int[] arr = { 10, 100, 200, 300, 1000, 20, 30 };

		// Number of elements to group
		int k = 3;

		int currentDiff = Integer.MAX_VALUE;

		if (arr.length < k || k == 1) {
			System.out.println("Invalid Entry to Group Elements");
			return;
		}

		// Sorted Array
		Arrays.sort(arr);

		int windowIndex = k - 1;
		int i = 0;
		while (i < arr.length && windowIndex < arr.length) {
			int maxminDiff = Math.max(arr[i], arr[windowIndex]) - Math.min(arr[i], arr[windowIndex]);
			if (currentDiff > maxminDiff) {
				currentDiff = maxminDiff;
			}
			i++;
			windowIndex++;
		}

		System.out.println("Unfairness Difference: " + currentDiff);

	}
}
