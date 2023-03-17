import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11085 {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			arr = new int[8];
			for(int i=0; i<8; i++) arr[i] = Integer.parseInt(split[i])-1;
			System.out.println("Case "+c+++": "+backtrack(0));
		}
	}
	
	static int backtrack(int index){
		if(valid()) return 0;
		if(index==8) return 100;
		int ans = 100;
		for(int i=0; i<8; i++)
			if(i==arr[index]){
				ans = Math.min(ans, backtrack(index+1));
			} else {
				boolean same = false;
				for(int j=0; !same && j<index; j++) {
					same|=arr[j]==i;
					same|=Math.abs(j-index)==Math.abs(i-arr[j]);
				}
				if(same) continue;
				int prev = arr[index];
				arr[index] = i;
				ans = Math.min(ans, backtrack(index+1)+1);
				arr[index] = prev;
			}
		return ans;
	}
	
	static boolean valid(){
		for(int i=0; i<8; i++){
			int r1 = i, c1 = arr[i];
			for(int j=i+1; j<8; j++){
				int r2 = j, c2 = arr[j];
				if(r1==r2 || c1==c2 || Math.abs(r1-r2)==Math.abs(c1-c2)) return false;
			}
		}
		return true;
	}
}
