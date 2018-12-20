package com.dataStr;
import java.util.Scanner;
public class Merge {

   /*  Merge the subarrays a[lo] .. a[mid-1] and a[mid] .. a[hi-1] into
    *  a[lo] .. a[hi-1] using the auxilliary array aux[] as scratch space.
    *  Precondition:   the two subarrays are in ascending order
    *  Postcondition:  a[lo] .. a[hi-1] is in ascending order*/
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)                 aux[k] = a[j++];
            else if (j == hi)                  aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else                               aux[k] = a[i++];
        }
        // copy back
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }


   /***************************************************************************
    *  Mergesort the subarray a[lo] .. a[hi-1], using the
    *  auxilliary array aux[] as scratch space.
    ***************************************************************************/
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // base case
        if (hi - lo <= 1) return;
        // sort each half, recursively
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        // merge back together
        merge(a, aux, lo, mid, hi);
    }

   /***************************************************************************
    *  Sort the array a using mergesort.
    ***************************************************************************/
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n);
    }

   /***************************************************************************
    *  Sort the subarray a[lo..hi] using mergesort.
    ***************************************************************************/
    public static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, lo, hi);
    }

   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

   /***************************************************************************
    *  Show results.
    ***************************************************************************/
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
        	 System.out.println(a[i]);
    }

   /***************************************************************************
    *  Test client.
    ***************************************************************************/
    public static void main(String[] args) {
    	
    	/* Scanner s = new Scanner(System.in);
         String[] array = new String[20];
         System.out.println("Please enter 20 names to sort");              
         for (int i = 0; i < 0;){
             array[i] = s.nextLine();
         }
        Merge.sort(array);
        assert isSorted(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();*/
    	// Scanner s = new Scanner(System.in);
         // = new String[20];
         System.out.println("Please enter 20 names to sort");              
         Scanner s1 = new Scanner(System.in);
       String str =   s1.next();
       String[] array =   str.toString().trim().split(",");
       System.out.println(array[2]);
       Merge.sort(array);
       assert isSorted(array);
       for (int i = 0; i < array.length; i++) {
           System.out.print(array[i] + " ");
       }
         //Just to test
        // System.out.println(array[0]);
    }
}
