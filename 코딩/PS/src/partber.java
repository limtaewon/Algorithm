import java.util.Scanner;

public class partber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[][] = new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				a[i][j]=scanner.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			a[i][2]=0;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					a[i][j]=a[i][j]+Math.max(a[i-1][1],a[i-1][2]);
				}
				else if(j==1) {
					a[i][j]=a[i][j]+Math.max(a[i-1][0], a[i-1][2]);
				}
				else {
					a[i][j]=a[i][j]+Math.max(a[i-1][0],a[i-1][1]);
				}
			}
		}
		System.out.println(Math.max(Math.max(a[n-1][0], a[n-1][1]), a[n-1][2]));
	
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
