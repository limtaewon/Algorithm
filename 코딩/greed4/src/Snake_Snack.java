import java.util.*;

public class Snake_Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer,Integer> time = new HashMap<>(); 
		int a[] = new int[N];
		int b[]= new int[N];
		for(int i=0;i<N;i++) {
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i]==a[j]) {
					if(b[i]>b[j]) {
						b[i]=b[j];
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			time.put(a[i],b[i]);
		}
		Object [] time_sort = time.keySet().toArray();
		Arrays.sort(time_sort);
		int min = 100000;
		for(int j=0;j<time_sort.length;j++) {
			min = Math.min(min,(Integer)time_sort[j]+time.get(time_sort[j]));
		}
		for(int i=0;i<time_sort.length;i++) {
			if(min == (Integer)time_sort[i]+time.get(time_sort[i]))
				min=i;
		}
		int result=0;
		int x = Find((Integer)time_sort[min]+time.get(time_sort[min]),time_sort,time);
			if(x!=-1) {
				result++;
				while(Find((Integer)time_sort[x]+time.get(time_sort[x]),time_sort,time) != -1) {
					result++;
					x=Find((Integer)time_sort[x]+time.get(time_sort[x]),time_sort,time);
				}
			}
		System.out.println(result+1);
	}
	public static int Find(int n, Object[] time_sort,HashMap<Integer,Integer> time) {
		int min = 10000000;
		int a =0;
		for(int i=0;i<time_sort.length;i++) {
			if(n<=(int)time_sort[i]) {
				for(int j=i;j<time_sort.length;j++) {
					min = Math.min(min,(Integer)time_sort[j]+time.get(time_sort[j]));
				}
				a=i;
				break;
			}
		}
		for(int i=a;i<time_sort.length;i++) {
			if(min == (Integer)time_sort[i]+time.get(time_sort[i]))
				return i; 
		}
		return -1;
	}
}