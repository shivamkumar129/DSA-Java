package Arrays;

import java.util.*;

public class FindMisingNrepeat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][]grid=new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(Arrays.toString(findMR(grid)));
        sc.close();

    }

    // Brute forcetype - Grid-> flat->sort->repeated->missing-> return
    static  int[] find(int[][]grid){

        int n=grid.length;
        int[]temp=new int[n*n];
        int k=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[k++]=grid[i][j];
            }
        }
        Arrays.sort(temp);
        int rep=-1;
        int missing=-1;
        for(int i=1;i<temp.length-1;i++){
          if(temp[i]==temp[i-1]){
            rep=temp[i];
            break;
          }
        }
        int exp=1;
        for(int i=0;i<temp.length;i++){
          if(temp[i]==exp){
            
           exp++;
          }
        }
        missing=exp;

        return new int[]{rep,missing};
    }
    static int[] findMR(int[][]grid){
        int n=grid.length;
        int freq[]=new int[n*n+1];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                freq[grid[i][j]]++;
            }
        }
        int rep=-1;
        int missing=-1;

    for(int i=0;i<freq.length;i++){
     if(freq[i]==2)rep=i;
     if(freq[i]==0)missing=i;
    }
    return new int[]{rep,missing};
    }
}
