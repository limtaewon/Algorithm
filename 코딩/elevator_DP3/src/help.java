import java.util.Scanner;

public class help {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int peb[][] = new int[n][4];
      for(int i=0;i<n;i++) {
         for(int j=0;j<3;j++) {
            peb[i][j] = sc.nextInt();
            peb[i][3] = peb[i][0]+peb[i][2];
         }
      }
   
      for(int i=1;i<n;i++) {
         for(int j=0;j<4;j++) {
            if(j==0)
               peb[i][j] = peb[i][j] + Math.max(peb[i-1][1],peb[i-1][2]);
            else if(j==1)
               peb[i][j] = peb[i][j] + Math.max(peb[i-1][0],Math.max(peb[i-1][2],peb[i-1][3]));
            else if(j==2)
               peb[i][j] = peb[i][j] + Math.max(peb[i-1][0],peb[i-1][1]);
            else
               peb[i][j]=peb[i][j]+peb[i-1][1];
         }
      }
      for(int i=0;i<4;i++) {
         peb[n-1][0] = Math.max(peb[n-1][0],peb[n-1][i]);
      }
      for(int i=0;i<n;i++) {
         for(int j=0;j<4;j++) {
            System.out.print(peb[i][j]+" ");
         }
         System.out.println();
      }
   }
}