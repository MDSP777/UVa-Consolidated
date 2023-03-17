import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_12049 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int l1 = Integer.parseInt(split[0]);
			int l2 = Integer.parseInt(split[1]);
			HashMap<Integer, Integer> freq1 = new HashMap<>();
			HashMap<Integer, Integer> freq2 = new HashMap<>();
			split = br.readLine().split("\\s+");
			for(int i=0; i<l1; i++) 
				if(!freq1.containsKey(Integer.parseInt(split[i]))) freq1.put(Integer.parseInt(split[i]), 1); 
				else freq1.put(Integer.parseInt(split[i]), freq1.get(Integer.parseInt(split[i]))+1);
			split = br.readLine().split("\\s+");
			for(int i=0; i<l2; i++) 
				if(!freq2.containsKey(Integer.parseInt(split[i]))) freq2.put(Integer.parseInt(split[i]), 1); 
				else freq2.put(Integer.parseInt(split[i]), freq2.get(Integer.parseInt(split[i]))+1);
			int total = 0;
			for(int i: freq1.keySet()) 
				if(!freq2.containsKey(i)) total+=freq1.get(i);
				else if(freq1.get(i)!=freq2.get(i)) total+=Math.abs(freq1.get(i)-freq2.get(i));
			for(int i: freq2.keySet()) 
				if(!freq1.containsKey(i)) total+=freq2.get(i);
			System.out.println(total);
		}
	}
}
