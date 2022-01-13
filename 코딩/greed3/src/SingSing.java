import java.util.Scanner;
import java.util.Arrays;

public class SingSing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []fruit = new int[N];
		for(int i=0;i<N;i++)
			fruit[i]=sc.nextInt();
		Arrays.sort(fruit);
		int sum =0;
		for(int i=1;i<N;i=i+2) {
			sum=sum+fruit[i];
		}
		System.out.println(sum);
	}
}