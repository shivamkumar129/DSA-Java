package Arrays;

import java.util.Scanner;

public class MaxPoints {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Size of array :");
    int n=sc.nextInt();
    int []arr=new int[n];
    System.out.println("array elements :");
    for (int i = 0; i < arr.length; i++) {
        arr[i]=sc.nextInt();
    }
    System.out.println("size of subarray :");
    int k=sc.nextInt();
    System.out.println(MaxPointsCard(arr,k));
}

private static int MaxPointsCard(int[] arr,int k) {
    int lsum=0,rsum=0;
    for (int i = 0; i < k; i++) {
        lsum+=arr[i];
        
    }
    int rIdx=arr.length-1;
    int maxLen=lsum;
    for(int i=k-1;i>=0;i--){
        lsum-=arr[i];
        rsum+=arr[rIdx];
        rIdx--;
    }

   return Math.max(maxLen, lsum+rsum);
}
    
}
