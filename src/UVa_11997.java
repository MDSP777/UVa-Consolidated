import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class UVa_11997 {
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String st = br.readLine();
			if(st==null || st.isEmpty()) break;
			n = Integer.parseInt(st);
			ArrayList<Integer>[] lists = new ArrayList[n];
			for(int i=0; i<n; i++) {
				lists[i] = new ArrayList<Integer>();
				String[] split = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					lists[i].add(Integer.parseInt(split[j]));
				}
				Collections.sort(lists[i]);
			}
			
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum+=lists[i].get(0);
			}
			HashSet<Sum> sums = new HashSet<>();
			PriorityQueue<Sum> ans = new PriorityQueue<>(new Comparator<Sum>() {

				@Override
				public int compare(Sum o1, Sum o2) {
					return o2.val-o1.val;
				}
			});
//			System.out.println("ADDIND "+sum);
			sums.add(new Sum(sum, new HashMap<Integer, Integer>()));
			ans.add(new Sum(sum, new HashMap<Integer, Integer>()));
			int[] lastUsedIndex = new int[n];
			for(int k=1; sums.size()<20*n && k<n; k++) {
//				System.out.println(k);
				int minDiff = 100000000;
				int minDiffIndex = -1;
				for(int i=0; i<n; i++) {
					if(lastUsedIndex[i]<n-1) {
						int diff = lists[i].get(lastUsedIndex[i]+1)-lists[i].get(0);
						if(diff<minDiff) {
							minDiff = diff;
							minDiffIndex = i;
						}
					}
//					System.out.println("MIN DIFF " + minDiff);
				}

				lastUsedIndex[minDiffIndex]++;
				ArrayList<Sum> toAdd = new ArrayList<>();
				for(Sum cur : ans) {
					if(sums.size()>=20*n) break;
					int toSubtract = cur.moved.containsKey(minDiffIndex) ? lists[minDiffIndex].get(cur.moved.get(minDiffIndex)) : lists[minDiffIndex].get(0);
//					System.out.println("SUBBING "+toSubtract+" FOR "+lists[minDiffIndex].get(lastUsedIndex[minDiffIndex]));
					int newSum = cur.val-toSubtract+lists[minDiffIndex].get(lastUsedIndex[minDiffIndex]);
					HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(cur.moved);
					map.put(minDiffIndex, lastUsedIndex[minDiffIndex]);
//					System.out.println("ADDING "+newSum);
					Sum x = new Sum(newSum, map);
					if(!sums.contains(x)) {
						toAdd.add(x);
						sums.add(x);
//						System.out.println(sums.size());
					}
				}
				for(Sum cur : toAdd) {
					ans.add(cur);
					while(ans.size()>n) ans.poll();
				}
			}
			Stack<Sum> stack = new Stack<>();
			while(!ans.isEmpty()) stack.add(ans.poll());
			sb.append(stack.pop().val);
			for(int i=1; i<n; i++) sb.append(" ").append(stack.pop().val);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class Sum implements Comparable<Sum>{
		int val;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((moved == null) ? 0 : moved.hashCode());
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sum other = (Sum) obj;
			if (moved == null) {
				if (other.moved != null)
					return false;
			} else if (!moved.equals(other.moved))
				return false;
			if (val != other.val)
				return false;
			return true;
		}

		HashMap<Integer, Integer> moved;
		
		Sum(int v, HashMap<Integer, Integer> m){
			val = v;
			moved = m;
		}

		@Override
		public int compareTo(Sum o) {
			return val-o.val;
		}
	}
	
}
