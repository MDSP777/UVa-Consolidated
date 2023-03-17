import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_796 {
	static int[] dfsLow;
	static int[] dfsNum;
	static int[] dfsParent;
	static int dfsCtr;
	static int dfsRoot;
	static int n;
	static ArrayList<Integer>[] e;
	static ArrayList<Bridge> bridges;

	static void f(int u){
		dfsLow[u] = dfsNum[u] = dfsCtr++;
		for(int i=0; i<e[u].size(); i++){
			int v = e[u].get(i);
			if(dfsNum[v]==-1){
				dfsParent[v] = u;
				f(v);
				if(dfsLow[v]>dfsNum[u]) bridges.add(new Bridge(u, v));
				dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
			} else if(v!=dfsParent[u]) dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			e = new ArrayList[n];
			for(int i=0; i<n; i++){
				int index = sc.nextInt();
				int ctr = Integer.parseInt(sc.next().replaceAll("[()]", ""));
				e[index] = new ArrayList<>();
				for(int j=0; j<ctr; j++) e[index].add(sc.nextInt());
			}
			dfsCtr = 0;
			dfsLow = new int[n];
			dfsNum = new int[n];
			dfsParent = new int[n];
			bridges = new ArrayList<>();
			for(int i=0; i<n; i++) dfsNum[i] = -1;
			for(int i=0; i<n; i++){
				dfsRoot = i;
				f(i);
			}
			Collections.sort(bridges);
			System.out.println(bridges.size()+" critical links");
			for(Bridge b : bridges) System.out.println(b.s+" - "+b.e);
			System.out.println();
		}
	}
	
	static class Bridge implements Comparable<Bridge>{
		int s;
		int e;
		
		public Bridge(int a, int b){
			s = Math.min(a, b);
			e = Math.max(a, b);
		}

		@Override
		public int compareTo(Bridge o) {
			if(s==o.s) return e-o.e;
			return s-o.s;
		}
	}
}
