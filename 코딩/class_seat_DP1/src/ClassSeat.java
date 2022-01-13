import java.math.BigInteger;
import java.util.Scanner;
public class ClassSeat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger cnt[]=new BigInteger[3];
		int N=sc.nextInt();
		BigInteger W[][] = new BigInteger[N][5];
		BigInteger Q[][]= new BigInteger[N][3];
		for(int i=0;i<3;i++){
		    Q[0][i]=new BigInteger("1");
		}
		for(int i=1;i<N;i++) {
			for(int j=0; j<3; j++) {
				if(j==0) {
					Q[i][j]=Q[i-1][1].add(Q[i-1][2]);
				}
				else if(j==1) {
					Q[i][j]=Q[i-1][0].add(Q[i-1][2]);
				}
				else {
					Q[i][j]=Q[i-1][0].add(Q[i-1][1]);
					Q[i][j]=Q[i][j].add(Q[i-1][2]);
				}
			}
		}
		for(int i=0;i<5;i++){
		    W[0][i]=new BigInteger("1");
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<5;j++) {
				if(j==0) {
					W[i][j]=W[i-1][2].add(W[i-1][1]);
					W[i][j]=W[i][j].add(W[i-1][4]);
				}
				else if(j==1) {
					W[i][j]=W[i-1][0].add(W[i-1][2]);
					W[i][j]=W[i][j].add(W[i-1][3]);
					W[i][j]=W[i][j].add(W[i-1][4]);
				}
				else if(j==2) {
					W[i][j]=W[i-1][0].add(W[i-1][1]);
					W[i][j]=W[i][j].add(W[i-1][4]);
				}
				else if(j==3) {
					W[i][j]=W[i-1][1].add(W[i-1][4]);
				}
				else {
					W[i][j]=W[i-1][0].add(W[i-1][1]);
					W[i][j]=W[i][j].add(W[i-1][2]);
					W[i][j]=W[i][j].add(W[i-1][3]);
					W[i][j]=W[i][j].add(W[i-1][4]);
				}
			}
		}
		cnt[0]=new BigInteger("0");
		cnt[1]=new BigInteger("0");
		for(int i=0; i<3;i++) {
			cnt[0]=cnt[0].add(Q[N-1][i]);
		}
		for(int i=0; i<5;i++) {
			cnt[1]=cnt[1].add(W[N-1][i]);
		}
		cnt[2]=cnt[0].multiply(cnt[0]);
		cnt[2]=cnt[2].multiply(cnt[1]);
		System.out.println(cnt[0]+" "+cnt[1]);
		BigInteger y=new BigInteger("1000000007");
		System.out.println(cnt[2].mod(y));
	}
}