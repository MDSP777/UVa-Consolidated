import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UVa_11413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			split = br.readLine().split(" ");
			int[] milk = new int[n];
			for(int i=0; i<n; i++) milk[i] = Integer.parseInt(split[i]);
			int l = 0;
			int h = 1000000000;
			int ans = h;
			for(int i=0; i<50; i++){
				int cap = (h+l)/2;
				if(can(milk, m, cap)){
					h = cap;
					ans = cap;
				} else l = cap;
			}
			System.out.println(ans);
		}
	}
	
	static boolean can(int[] milk, int m, int cap){
		int curC = 0;
		int ctr = 0;
		for(int i=0; i<milk.length; i++){
			if(curC+milk[i]>cap){
				ctr++;
				curC = 0;
				i--;
				if(ctr==m) return false;
			} else curC+=milk[i];
		}
		return true;
	}
}
