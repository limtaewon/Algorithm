import java.util.Scanner;
public class help {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] W = new int[N][4];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				W[i][j]=sc.nextInt();
				System.out.print(W[i][j]);
			}
		}
		int sum = W[0][0];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				sum+=Math.max(W[i+1][j],W[i][j+1]);
			}
		}
		System.out.println(sum);
	}

}
