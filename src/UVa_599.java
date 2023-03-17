import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_599 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			boolean[][] adj = new boolean[26][26];
			while(true) {
				String s = br.readLine();
				if(s.contains("*")) break;
				adj[s.charAt(1)-'A'][s.charAt(3)-'A'] = adj[s.charAt(3)-'A'][s.charAt(1)-'A'] = true;
			}
			String s = br.readLine().replaceAll("[^A-Z]", "");
			BitSet bs = new BitSet();
			int trees = 0;
			int acorns = 0;
			for(int i=0; i<s.length(); i++) {
				if(!bs.get(s.charAt(i)-'A')) {
					int total = 0;
					LinkedList<Integer> q = new LinkedList<>();
					q.add(s.charAt(i)-'A');
					bs.set(s.charAt(i)-'A');
					while(!q.isEmpty()) {
						int cur = q.poll();
						total++;
						for(int j=0; j<26; j++) if(adj[cur][j] && !bs.get(j)) {
							bs.set(j);
							q.add(j);
						}
					}
					if(total==1) acorns++;
					else trees++;
				}
			}
			System.out.println("There are "+trees+" tree(s) and "+acorns+" acorn(s).");
		}
	}
}


/*
Note: BFS approach works but UFDS approach doesn't. IDK why

WA UFDS approach:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_599 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			ArrayList<Character> x = new ArrayList<>();
			ArrayList<Character> y = new ArrayList<>();
			int index = 0;
			HashMap<Character, Integer> map = new HashMap<>();
			while(true) {
				String s = br.readLine().replaceAll("[^A-Z]", "");
				if(s.isEmpty()) break;
				if(!map.containsKey(s.charAt(0))) map.put(s.charAt(0), index++);
				if(!map.containsKey(s.charAt(1))) map.put(s.charAt(1), index++);
				x.add(s.charAt(0));
				y.add(s.charAt(1));
			}
			String s = br.readLine().replaceAll("[^A-Z]", "");
			DisjointSet ds = new DisjointSet(s.length());
			for(int i=0; i<x.size(); i++) ds.union(map.get(x.get(i)), map.get(y.get(i)));
			HashMap<Integer, Integer> res = new HashMap<>();
			for(int i=0; i<s.length(); i++) if(!res.containsKey(ds.p[i])) res.put(ds.p[i], 1); else res.put(ds.p[i], res.get(ds.p[i])+1);
			int trees = 0;
			int acorns = 0;
			for(int i : res.values()) if(i==1) acorns++; else trees++;
			System.out.println("There are "+trees+" tree(s) and "+acorns+" acorn(s).");
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) p[i] = i;
		}
		
		int findSet(int i) {
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j) {
			return findSet(i)==findSet(j);
		}
		
		void union(int i, int j) {
			if(!isSameSet(i, j)) {
				int x = findSet(i);
				int y = findSet(j);
				if(rank[y]>rank[x]) p[x] = y;
				else {
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
			}
		}
	}
}

*/