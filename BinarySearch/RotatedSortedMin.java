// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.

 package BinarySearch;

import java.util.Scanner;

class RotatedSortedMin {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(arr));
        sc.close();
    }

    private static int find(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start<end) {
            int mid=start+(end-start)/2;
            if (arr[mid]>arr[end]) {
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
       return arr[start];
    }
    
}
