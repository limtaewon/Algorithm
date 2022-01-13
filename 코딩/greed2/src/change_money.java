import java.io.*;
import java.util.*;
public class change_money {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int money[] = new int[N];
		int result = 0;
		for(int i=0;i<N;i++)
			money[i]=Integer.parseInt(br.readLine());
		while(K!=0) {
			if(money[N-1]<=K) {
				K=K-money[N-1];
				result++;
			}
			else
				N--;
		}
		System.out.println(result);
	}
}
