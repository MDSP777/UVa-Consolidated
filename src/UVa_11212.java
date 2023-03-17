import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11212 {
	static int ans;
	static int n;
	static HashSet<State> left;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			int[] arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = sc.nextInt();
			ans = 5;
			left = new HashSet<>();
			bfs(arr);
			if(ans==5) bfs2();
			System.out.println("Case "+t+++": "+ans);
		}
	}
	
	static void bfs(int[] start){
		HashSet<State> visited = new HashSet<>();
		LinkedList<State> q = new LinkedList<>();
		q.add(new State(start, 0));
		visited.add(new State(start));
		while(!q.isEmpty()){
			State cur = q.poll();
			if(isFinal(cur.arr)){
				ans = cur.depth;
				return;
			}
			if(cur.depth==2) left.add(new State(cur.arr));
			else {
				for(int i=0; i<cur.arr.length; i++){
					for(int j=i; j<cur.arr.length; j++){
						int[] cut = new int[j-i+1]; // chunk to be removed
						int[] rem = new int[cur.arr.length - (j-i+1)]; // remaining
						for(int idx=i; idx<=j; idx++) cut[idx-i] = cur.arr[idx];
						int ctr = 0;
						for(int idx=0; idx<cur.arr.length; idx++)
							if(idx<i || idx>j) rem[ctr++] = cur.arr[idx];
						for(int k=0; k<=rem.length; k++){
	//						all possible paste points, before first until after last
							int[] newArr = new int[cur.arr.length];
							int remCtr = 0, newArrCtr = 0;
							for(int l=0; l<k; l++) newArr[newArrCtr++] = rem[remCtr++];
							for(int l=0; l<cut.length; l++) newArr[newArrCtr++] = cut[l];
							for(int l=k; l<rem.length; l++) newArr[newArrCtr++] = rem[remCtr++];
							if(!visited.contains(new State(newArr))){
								visited.add(new State(newArr));
								q.add(new State(newArr, cur.depth+1));
							}
						}
					}
				}
			}
		}
	}
	
	static void bfs2(){
		int[] start = new int[n];
		for(int i=0; i<n; i++) start[i] = i+1;
		HashSet<State> visited = new HashSet<>();
		LinkedList<State> q = new LinkedList<>();
		q.add(new State(start, 0));
		visited.add(new State(start));
		while(!q.isEmpty()){
			State cur = q.poll();
			if(left.contains(new State(cur.arr))){
				ans = cur.depth+2;
				return;
			}
			if(cur.depth<2) {
				for(int i=0; i<cur.arr.length; i++){
					for(int j=i; j<cur.arr.length; j++){
						int[] cut = new int[j-i+1]; // chunk to be removed
						int[] rem = new int[cur.arr.length - (j-i+1)]; // remaining
						for(int idx=i; idx<=j; idx++) cut[idx-i] = cur.arr[idx];
						int ctr = 0;
						for(int idx=0; idx<cur.arr.length; idx++)
							if(idx<i || idx>j) rem[ctr++] = cur.arr[idx];
						for(int k=0; k<=rem.length; k++){
	//						all possible paste points, before first until after last
							int[] newArr = new int[cur.arr.length];
							int remCtr = 0, newArrCtr = 0;
							for(int l=0; l<k; l++) newArr[newArrCtr++] = rem[remCtr++];
							for(int l=0; l<cut.length; l++) newArr[newArrCtr++] = cut[l];
							for(int l=k; l<rem.length; l++) newArr[newArrCtr++] = rem[remCtr++];
							if(!visited.contains(new State(newArr))){
								visited.add(new State(newArr));
								q.add(new State(newArr, cur.depth+1));
							}
						}
					}
				}
			}
		}
	}
	
	static boolean isFinal(int[] arr){
		for(int i=0; i<arr.length; i++) if(arr[i]!=i+1) return false;
		return true;
	}
	
	
	static class State {
		int[] arr;
		int depth;
		
		State(int[] a, int b){
			arr = a;
			depth = b;
		}
		
		State(int[] a){
			arr = a;
			depth = 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(arr);
			result = prime * result + depth;
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
			State other = (State) obj;
			if (!Arrays.equals(arr, other.arr))
				return false;
			if (depth != other.depth)
				return false;
			return true;
		}
		
	}
}
