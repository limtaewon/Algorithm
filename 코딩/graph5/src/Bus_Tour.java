import java.util.*;

public class Bus_Tour {
	static int count=0;
	static int extraMin(int a, int b) {
		if(a==-1 && b!= -1) 
			return b;
		else if(a!=-1 && b==-1)
			return a;
		else if (a==-1 && b==-1)
			return -1;
		else {
			return Math.min(a,b);
		}
	}
	static int extraSum(int a, int b) {
		if(a==-1 && b==-1) {
			return -1;
		}
		else if (a==-1||b==-1) {
			return -1;
		}
		else {
			return a+b;
		}
	}
	static void F_WS(int [][] Z, int[][] list,int N) {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					Z[k][i] = extraMin(Z[k][i],extraSum(Z[k][j],list[j][i]));
				}
			}
		}
		if(count==N-1)
			print(Z,N);
		else {
			count++;
			F_WS(Z,list,N);
		}
	}
	static void print(int[][] Z,int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(Z[i][j]==-1)
					System.out.print("0 ");
				else
					System.out.print(Z[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();int M = sc.nextInt();
		int list[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				list[i][j] = -1;	
				if(i==j)
					list[i][j] = 0;
			}
		}
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt();int b=sc.nextInt();int c = sc.nextInt();
			int z = list[a-1][b-1];
			if(z!=-1 && z<c) 
				list[a-1][b-1] = z;	
			
			else 
				list[a-1][b-1] = c;
		}
		F_WS(list,list,N);
	}
}