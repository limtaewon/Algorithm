import java.util.*;

public class Color_change {
	static int x[] = {-1,1,0,0};
	static int y[] = {0,0,-1,1};
	static int color[] = new int[9];
	static ArrayList<ArrayList<Integer>> Node = new ArrayList<ArrayList<Integer>>(9);
	static boolean visit[] = new boolean[9];
	static int count = 0;
	static void Connect_list() {
		for(int i=0;i<9;i++) {
			Node.add(new ArrayList<Integer>());
		}
		int cnt = 0;
		for(int z=0;z<3;z++) {
			for(int j=0;j<3;j++) {
				for(int i=0;i<4;i++) {
					int xx = j+x[i];
					int yy = z+y[i];
					while(true) {
						if(xx<0||xx>2||yy<0||yy>2) 
							break;
						else {
							if(x[i]!=0) {
								Node.get(cnt).add(cnt+x[i]);
								break;
							}
							else if(y[i]==1) {
								Node.get(cnt).add(cnt+3);
								break;
							}
							else if(y[i]==-1) {
								Node.get(cnt).add(cnt-3);
								break;
							}
							else
								break;
						}
					}
				}
				cnt++;
			}
		}
	}
	public static void Change(StringBuffer s,int n) {
		if(s.charAt(n)=='0') {
			s.insert(n,"1");
			for(int i:Node.get(n)) {
				if(s.charAt(i)=='1') 
					s.insert(i,"0");
				else
					s.insert(i,"1");
			}
		}
		else {
			color[n]=0;
			for(int i:Node.get(n)) {
				if(color[i]==0) 
					color[i]=1;
				else
					color[i]=0;
			}
			
		}
		count++;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer s = new StringBuffer("");
		String sl = new String();
		int[][] list = new int[3][3];
		int l =0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				sl = Integer.toString(sc.nextInt());
				s=s.append(sl);
			}
		}
		Connect_list();
	}
}