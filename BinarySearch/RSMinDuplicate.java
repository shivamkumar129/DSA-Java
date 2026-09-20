package BinarySearch;

import java.util.Scanner;

public class RSMinDuplicate {
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
         int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]==arr[end]){
                end--;
                }
            else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return arr[start];
    }
}
