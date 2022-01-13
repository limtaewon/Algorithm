import java.util.Scanner;

public class PS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W[][] = new int[N][2]; 
		int peb[][] = new int[N][1];
		int p[] = new int[3];
		for(int i =0 ; i<N; i++) {
			for(int j=0; j<2; j++) {
				W[i][j]=sc.nextInt();
				W[i][2]=0;
				peb[i][0]=0;
			}
		}
		peb[0][0]=Math.max(W[0][0],W[0][1]);
		for(int i=0;i<N;i++) {
			for(int j=0;j<2;j++) {
				if(W[i][j]<W[i+1][j])
			}
		}
		peb[0][2]=0;
		
		

	}

}
