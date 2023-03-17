import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UVa_103 {
	static int[] memo, next;
	static ArrayList<Box> boxes;
	static int n,l;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			n = sc.nextInt();
			l = sc.nextInt();
			boxes = new ArrayList<>();
			for(int i=0; i<n; i++){
				ArrayList<Integer> dims = new ArrayList<>();
				for(int j=0; j<l; j++)
					dims.add(sc.nextInt());
				Collections.sort(dims);
				boxes.add(new Box(dims, i+1));
			}
			Collections.sort(boxes);
			memo = new int[n];
			next = new int[n];
			Arrays.fill(memo, -1);
			Arrays.fill(next, -1);
			int ans = dp(0);
			for(int i=1; i<n; i++) ans = Math.max(ans, dp(i));
			
			System.out.println(ans);
			int ansIdx = -1;
			for(int i=0; i<n; i++)
				if(memo[i]==ans){
					ansIdx = i;
				}
			System.out.print(boxes.get(ansIdx).idx);
			ansIdx = next[ansIdx];
			while(ansIdx!=-1){
				System.out.print(" "+boxes.get(ansIdx).idx);
				ansIdx = next[ansIdx];
			}
			System.out.println();
		}while(sc.hasNext());
	}
	
	static int dp(int idx){
		if(idx==n) return 1;
		if(memo[idx]!=-1) return memo[idx];
		int ans = 1;
		for(int i=idx+1; i<n; i++)
			if(fits(boxes.get(idx), boxes.get(i))){
				int nextAns = 1+dp(i);
				if(nextAns>ans){
					ans = nextAns;
					next[idx] = i;
				}
			}
		return memo[idx] = ans;
	}
	
	static boolean fits(Box a, Box b){
		boolean canFit = true;
		for(int j=0; j<l && canFit; j++)
			canFit&=a.dims.get(j)<b.dims.get(j);
		return canFit;
	}
	
	static class Box implements Comparable<Box> {
		ArrayList<Integer> dims;
		int idx;
		
		Box(ArrayList<Integer> dims, int i){
			this.dims = dims;
			idx = i;
		}

		@Override
		public int compareTo(Box o) {
			for(int i=0; i<dims.size(); i++)
				if(dims.get(i)!=o.dims.get(i))
					return dims.get(i)-o.dims.get(i);
			return 0;
		}
		
	}
}
