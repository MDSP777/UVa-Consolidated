import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11283 {
	static char[][] grid;
	static Node[] trie;
	static boolean[] found;
	static int[] scores;
	static int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		grid = new char[4][];
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=tc; t++){
			br.readLine();
			for(int i=0; i<4; i++) grid[i] = br.readLine().trim().toUpperCase().toCharArray();
			int n = Integer.parseInt(br.readLine().trim());
			trie = new Node[26];
			found = new boolean[n];
			scores = new int[n];
			for(int i=0; i<n; i++){
				char[] s = br.readLine().trim().toUpperCase().toCharArray();
				if(s.length<=4) scores[i] = 1;
				else if(s.length==5) scores[i] = 2;
				else if(s.length==6) scores[i] = 3;
				else if(s.length==7) scores[i] = 5;
				else scores[i] = 11;
				
				if(trie[s[0]-'A']==null) trie[s[0]-'A'] = new Node(s[0]);
				Node cur = trie[s[0]-'A'];
				for(int j=1; j<s.length; j++){
					if(cur.next[s[j]-'A']==null) cur.next[s[j]-'A'] = new Node(s[j]);
					cur = cur.next[s[j]-'A'];
					if(j==s.length-1){
						cur.isEnd = true;
						cur.idx = i;
					}
				}
			}
			for(int i=0; i<4; i++)
				for(int j=0; j<4; j++)
					if(trie[grid[i][j]-'A']!=null)
						bt(i, j, trie[grid[i][j]-'A'], 1<<findMask(i, j));
			
			int total = 0;
			for(int i=0; i<n; i++)
				if(found[i]) total+=scores[i];
			sb.append(String.format("Score for Boggle game #%d: %d\n", t, total));
		}
		System.out.print(sb);
	}
	
	static void bt(int curR, int curC, Node curNode, int mask){
		if(curNode.isEnd)
			found[curNode.idx] = true;
		
		for(int x=0; x<8; x++){
			int newR = curR+rOffsets[x];
			int newC = curC+cOffsets[x];
			if(newR>=0 && newR<4 && newC>=0 && newC<4 &&
					 curNode.next[grid[newR][newC]-'A']!=null){
				int m = findMask(newR, newC);
				if((mask & (1<<m))==0)
					bt(newR, newC, curNode.next[grid[newR][newC]-'A'], mask | (1<<m));
			}
		}
	}
	
	static int findMask(int i, int j){
		return 4*i+j;
	}
	
	static class Node {
		char val;
		boolean isEnd;
		int idx;
		Node[] next;
		
		Node(char c){
			val = c;
			isEnd = false;
			idx = -1;
			next = new Node[26];
		}
	}
}
