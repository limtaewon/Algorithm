import java.util.Scanner;
import java.util.ArrayList;
class Nod{
	private ArrayList<ArrayList<Integer>> nod_list;
	public Nod(int N) {
		this.nod_list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++) {
			nod_list.add(new ArrayList<Integer>());
		}
	}
	public void setNod(int a, int b) {
		this.nod_list.get(a-1).add(b);
		this.nod_list.get(b-1).add(a);
	}
	public void printGraph() {
		for(int i=0;i<nod_list.size();i++) {
			for(int j=0;j<nod_list.get(i).size();j++) {
				System.out.print(nod_list.get(i).get(j)+" ");
			}
			System.out.println();
		}	 
	}
}
public class Graph_Expression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Nod list = new Nod(N);
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.setNod(a,b);
		}
		list.printGraph();
	}
}