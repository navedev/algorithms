package algo;

import java.util.Arrays;

/**
 * 
 * Given 3 arrays a, b, c of different sizes, find the number of DISTINCT
 * triplets(p,q,r) where p is an element of a, q of b and r of c, and satisfying
 * the criteria: p <= q and q >= r
 * 
 * @author ndevara
 *
 */
public class TripleSum {

	public static void main(String[] args) {
		int[] a = { 1, 4, 5 };
		int[] b = { 2, 3, 3 };
		int[] c = { 1, 2, 3 };
		long tripleSumCount = 0;

		int[] arr = Arrays.stream(a).sorted().distinct().toArray();
		int[] brr = Arrays.stream(b).sorted().distinct().toArray();
		int[] crr = Arrays.stream(c).sorted().distinct().toArray();

		int i, j, k;
		i = j = k = 0;
		while (j < brr.length) {
			while (i < arr.length && arr[i] <= brr[j])
				i++;

			while (k < crr.length && crr[k] <= brr[j])
				k++;

			tripleSumCount += (long) i * k;
			j++;
		}

		System.out.println("Triple Sum Count: " + tripleSumCount);
	}

}
