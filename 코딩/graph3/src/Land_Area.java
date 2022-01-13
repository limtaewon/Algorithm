import java.util.Scanner;
public class Land_Area {
	static int max = 0;
	static boolean load[][];
	public static int Dfs_Search(boolean load[][],int W[][], int a, int b,int w, int h) {
		load[a][b]=true;
		int x[] = {1,-1,0,0,1,1,-1,-1};
		int y[] = {0,0,1,-1,1,-1,1,-1};
		for(int i=0;i<8;i++) {
			int d_x = a+x[i];
			int d_y = b+y[i];
			if(d_x>=0 && d_x<w && d_y>=0 &&d_y<h) {
				if(W[d_x][d_y]==1 && load[d_x][d_y]==false) {
					max++;
					Dfs_Search(load,W,d_x,d_y,w,h);
				}
			}
		}
		return max;
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w =sc.nextInt();
		int h = sc.nextInt();
		int result = 0;
		load = new boolean[w][h];
		int W[][] = new int[w][h];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				W[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(W[i][j]==1) {
					max=1;
					result = Math.max(result,Dfs_Search(load,W,i,j,w,h));
				}
			}
		}
		System.out.println(result);
	}
}