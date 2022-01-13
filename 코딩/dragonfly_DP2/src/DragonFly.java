import java.util.Scanner;
public class DragonFly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int	w = sc.nextInt();
		int W[][] = new int[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				W[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(w>=3) {
					if(j==0) {
						W[i][j]=W[i][j]+Math.max(W[i-1][j],W[i-1][j+1]);
					}
					else if(j==w-1) {
						W[i][j]=W[i][j]+Math.max(W[i-1][j],W[i-1][j-1]);
					}
					else {
						W[i][j]=W[i][j]+Math.max(Math.max(W[i-1][j],W[i-1][j+1]),W[i-1][j-1]);
					}
				}
				else if(w==2) {
					if(j==0) {
						W[i][j]=W[i][j]+Math.max(W[i-1][j],W[i-1][j+1]);
					}
					else{
						W[i][j]=W[i][j]+Math.max(W[i-1][j],W[i-1][j-1]);
					}
				}
				else{
					W[i][j]=W[i][j]+W[i-1][j];
					
				}
			}
		}
		int result=0;
		for(int i=0;i<w;i++) {
			result=Math.max(result,W[h-1][i]);
		}
		System.out.println(result);
	}
}