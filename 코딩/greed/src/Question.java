import java.util.Scanner;
public class Question {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] group = new int[3];
		int[] idea = new int[3];
		for(int i=0;i<3;i++) {
			group[i]=sc.nextInt();
		}
		for(int i=0;i<3;i++) {
			idea[i] = sc.nextInt();
		}
		calculate(group,idea);
	}
	static void calculate(int[] group, int[] idea) {
		int i=2; int j=2;
		while(true) {
			int x=group[j];
			group[j]=group[j]-idea[i];
			if(group[j]>0) {
				i--;
			}
			else {
				idea[i]=idea[i]-x;
				if(idea[i]==group[j]) {
					i--;j--;
				}
				else
					j--;
			}
			if(j-i==2) {
				j--;
			}
			if(i<0 || j<0)
				break;
		}
		if(i<0 || i==j) {
			System.out.println("YES");
		}
		else if(j<0) {
			System.out.println("NO");
		}
	}
}