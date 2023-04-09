import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_10817 {
	static Teacher[] teachers;
	static int[][] memo;
	static int s, n, target;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split(" ");
			s = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			n = Integer.parseInt(split[2]);
			if(s==0 && m==0 && n==0) break;
			
			teachers = new Teacher[m+n];
			for(int i=0; i<m; i++) {
				split = br.readLine().split(" ");
				int cost = Integer.parseInt(split[0]);
				int subj = 0;
				for(int j=1; j<split.length; j++) 
					subj |= 1<<(Integer.parseInt(split[j])-1);
				
				teachers[i] = new Teacher(cost, subj, true);
			}
			
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				int cost = Integer.parseInt(split[0]);
				int subj = 0;
				for(int j=1; j<split.length; j++) 
					subj |= 1<<(Integer.parseInt(split[j])-1);
				
				teachers[m+i] = new Teacher(cost, subj, false);
			}
			n+=m;
			target = 1<<(2*s);
			memo = new int[n][target];
			for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);
			
			System.out.println(dp(0, 0));
		}
	}
	
	static int dp(int index, int mask) {
		if(index==n)
			return mask==target-1 ? 0 : 900000000;
		
		if(mask==target-1 && !teachers[index].mustHire) return 0;
		if(memo[index][mask]!=-1) return memo[index][mask];
		
		Teacher cur = teachers[index];
		int newMask = mask;
		for(int i=0; i<s; i++) {
			if((cur.subjects & (1<<i)) != 0) {
				int hasOne = mask & (1<<(2*i));
				int hasTwo = mask & (1<<(2*i+1));
				if(hasOne==0) { // allocate as first teacher
					newMask |= 1<<(2*i);
				} else if(hasTwo==0) { // allocate as second teacher
					newMask |= 1<<(2*i+1);
				} 
			}
		}
		
		return memo[index][mask] = Math.min(dp(index+1, newMask)+cur.cost, 
												dp(index+1, mask)+(cur.mustHire ? cur.cost : 0));
	}
	
	static class Teacher{
		int cost, subjects;
		boolean mustHire;
		
		Teacher(int a, int b, boolean x){
			cost = a;
			subjects = b;
			mustHire = x;
		}
	}
}
