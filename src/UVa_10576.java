import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10576 {
	static long[] months;
	static long max, s, d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str = br.readLine();
			if(str==null) break;
			String[] split = str.split(" ");
			s = Long.parseLong(split[0]);
			d = Long.parseLong(split[1]);
			months = new long[12];
			max = -1;
			backtrack(0);
			System.out.println(max<0 ? "Deficit" : max);
		}
	}
	
	static void backtrack(int index){
		if(index==11){
			long sum = 0;
			for(int i=7; i<11; i++) sum+= months[i]==s ? months[i] : -months[i];
			if(sum+s<0) {
				months[11] = s;
				max = Math.max(max, sum(months));
			}
			if(sum-d<0) {
				months[11] = d;
				max = Math.max(max, sum(months));
			}
		} else {
			if(index<4){
				months[index] = s;
				backtrack(index+1);
				months[index] = d;
				backtrack(index+1);
			} else {
				long sum = 0;
				for(int i=index-4; i<index; i++) sum+= months[i]==s ? months[i] : -months[i];
				if(sum+s<0){
					months[index] = s;
					backtrack(index+1);
				}
				if(sum-d<0){
					months[index] = d;
					backtrack(index+1);
				}
			}
		}
	}
	
	static long sum(long[] arr){
		long sum = 0;
		for(int i=0; i<arr.length; i++) sum+=arr[i]==s ? arr[i] : -arr[i];
		return sum;
	}
}
