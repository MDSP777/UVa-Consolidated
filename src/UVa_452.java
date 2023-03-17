import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class UVa_452 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0){
			HashMap<Integer, Integer> time = new HashMap<>();
			HashMap<Integer, String> prereqs = new HashMap<>();
			int[] inD = new int[26];
			int[] outD = new int[26];
			ArrayList<Integer>[] e = new ArrayList[26];
			for(int i=0; i<26; i++) e[i] = new ArrayList<>();
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split(" ");
				time.put(split[0].charAt(0)-'A', Integer.parseInt(split[1])*-1);
				if(split.length>2) {
					prereqs.put(split[0].charAt(0)-'A', split[2]);
					for(int i=0; i<split[2].length(); i++) {
						outD[split[2].charAt(i)-'A']++;
						e[split[2].charAt(i)-'A'].add(split[0].charAt(0)-'A');
					}
					inD[split[0].charAt(0)-'A'] = split[2].length();
				}
			}
			ArrayList<Integer> ts = new ArrayList<>();
			int[] dist = new int[26];
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i=0; i<26; i++) 
				if(inD[i]==0 && outD[i]>0) {
					q.add(i);
					dist[i] = time.get(i);
				}
			while(!q.isEmpty()){
				int cur = q.poll();
				ts.add(cur);
				for(int next: e[cur]){
					inD[next]--;
					if(inD[next]==0) q.add(next);
				}
			}
			for(int i : ts){
				String p = prereqs.get(i);
				for(int j=0; p!=null && j<p.length(); j++){
					dist[i] = Math.min(dist[i], dist[p.charAt(j)-'A']+time.get(i));
				}
			}
			int ans = 0;
			for(int i=0; i<26; i++) ans = Math.min(ans, dist[i]);
			System.out.println(ans*-1);
			if(nC>0) System.out.println();
		}
	}
}
