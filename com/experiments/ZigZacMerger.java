/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class ZigZacMerger {

	/**
	 * @param args
	 */
	public static int[] ZigZacMerge(int[] a, int[] b) {
		int start1 = 0, start2 = 0;
		int end1 = a.length, end2 = b.length;
		int[] result = new int[end1+end2-1];
		int counter = 0;
		end1--;
		end2--;
		while ((start1 < end1) || (start2 < end2)) {
			if ((start1 < end1) & (start2 > end2)) {
				result[counter++] = b[start2++];
				result[counter++] = b[end2--];
			}
			else if ((start1 > end1) & (start2 < end2)) {
				result[counter++] = a[start1++];
				result[counter++] = a[end1--];
			}
			else {
				if (a[start1] < b[start2]) result[counter++] = a[start1++];
				else result[counter++] = b[start2++];
				if (a[end1] < b[end2]) result[counter++] = b[end2--];
				else result[counter++] = a[end1--];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,5,7,8,10,12,15};
		int[] b = {9,11,13,17,18,21};
		int[] result = ZigZacMerge(a,b);
		System.out.print("[");
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.print("]");
	}

}
