import java.util.Scanner;
import java.util.ArrayList;
class Dfs_Search{
	private ArrayList<ArrayList<Integer>> node_list;
	private boolean load[];
	private int result;
	public Dfs_Search(int Node) {
		node_list = new ArrayList<ArrayList<Integer>>(Node);
		load = new boolean[Node+1];
		result = 1;
		for(int i=0;i<Node+1;i++) {
			node_list.add(new ArrayList<Integer>());
		}
	}
	public void setNode(int a, int b) {
		node_list.get(a).add(b);
	}
	public void Search(int Node) {
		this.load[Node]=true;
		for(int i : this.node_list.get(Node)) {
			if(load[i]==false) {
				this.result++;
				Search(i);
			}
		}
	}
	public void printResult() {
		System.out.println(this.result);
	}
}
public class Domino {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		Dfs_Search domino = new Dfs_Search(N);
		int M = sc.nextInt();
		int first = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		domino.setNode(a,b);
		first=a;
		for(int i=0;i<M-1;i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			domino.setNode(a,b);
		}
		domino.Search(1);
		domino.printResult();
	}
}