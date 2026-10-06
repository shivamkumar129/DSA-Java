package Arrays;

import java.util.*;

public class ProductExceptSelf {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        sc.close();

        System.out.println(Arrays.toString(ProdExSelf(arr)));

    }

    private static int[] ProdExSelf(int[] arr) {
      int[] ans=new int[arr.length];
      int leftprod=1;
      for (int i = 0; i < arr.length; i++) {
        ans[i]=leftprod;
        leftprod*=arr[i];
      }
      int rightprod=1;
      for (int i = arr.length-1; i>=0; i--) {
        ans[i]*=rightprod;
        rightprod*=arr[i];
      }

      return ans;
    }
    
}
