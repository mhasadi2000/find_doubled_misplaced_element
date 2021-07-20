//package com.company;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.Scanner;

/* Java program for Merge Sort */
class Main
{

    static long counter=0;
    static long[] arr;
    static void merge( long l, long m, long r)
    {
        // Find sizes of two subarrays to be merged
        long n1 = m - l + 1;
        long n2 = r - m;

        /* Create temp arrays */
        long[] L = new long[(int) n1];
        long[] R = new long[(int) n2];

        /*Copy data to temp arrays*/
        for (long i = 0; i < n1; ++i)
            L[(int) i] = arr[(int) (l + i)];
        for (long j = 0; j < n2; ++j)
            R[(int) j] = arr[(int) (m + 1 + j)];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        long i = 0, j = 0;

        // Initial index of merged subarry array
        long k = l;
        while (i != n1 && j != n2) {
            if (L[(int) i] <= R[(int) j]) {
                arr[(int) k] = L[(int) i];
                i++;
            }
            else {
                arr[(int) k] = R[(int) j];
                j++;
            }
            k++;
        }
        int a=0,b=0;
        while (a < n1 && b < n2) {
            try{
                if (L[a] > R[b] * 2) {
                    counter += n1 - a;
                    b++;
                } else {
                    a++;
                }
            }catch (Exception ignored){}
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[(int) k] = L[(int) i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[(int) k] = R[(int) j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort( int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort( l, m);
            sort(m + 1, r);

            // Merge the sorted halves
            merge( l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
    {


        Scanner scn=new Scanner(System.in);
        int n=Integer.parseInt(scn.nextLine());
        arr = new long[n];
        int i=0;
        while (i<n){
            arr[i]=scn.nextInt();
            i++;
        }
//        System.out.println("Given Array");
//        printArray(arr);

        sort( 0, arr.length - 1);

//        System.out.println("\nSorted array");
//        printArray(arr);
        System.out.println(counter);
    }
}
/* This code is contributed by Rajat Mishra */
