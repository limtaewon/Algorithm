import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

class Bfs{
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private ArrayList<ArrayList<Integer>> people;
	private int load[];
	private boolean result;
	private int depth;

	public Bfs(int N) {
		this.people = new ArrayList<ArrayList<Integer>>(N);
		this.load = new int[N];
		this.result = false;
		this.depth =0;
		for(int i=0;i<N;i++) {
			people.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N;i++) {
			load[i]=-1;
		}
	}
	public void setBfs(int a, int b) {
		people.get(a-1).add(b);
		people.get(b-1).add(a);
	}
	public void Bfs_Search(int p, int q) {
		load[p-1]=0;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(p);
		while(queue.size() != 0) {
			p = queue.get(0);
			queue.remove(0);
			Iterator<Integer> i = people.get(p-1).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(load[n-1]==-1) {
					load[n-1] = load[p-1]+1;
					queue.add(n);
				}
				if(n==q) {
					result = true;
					load[n-1]=load[p-1]+1;
					break;
				}
			}
			if(result == true) 
				break;
		}
		depth = load[q-1];
	}

	public void printResult() throws IOException {
		if(result == true) {
			for(int i=1;i<this.depth;i++) {
				bw.write("아는 사람의 ");
			}
			bw.write("아는 사람");
		}
		else {
			bw.write("모르는 사람");
		}
		bw.flush();
	}
}
public class Knowing_People {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();int M = sc.nextInt();
		Bfs list = new Bfs(N);
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();int b= sc.nextInt();
			list.setBfs(a,b);
		}
		int p =sc.nextInt();int q = sc.nextInt();
		list.Bfs_Search(p,q);
		list.printResult();
	}
}