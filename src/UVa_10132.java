import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_10132 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0) {
			ArrayList<String> strings = new ArrayList<>();
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				strings.add(s);
			}
			HashMap<String, Integer> freq = new HashMap<>();
			int max = 0;
			for(int i=0; i<strings.size(); i++)
				for(int j=0; j<i; j++) {
					String toAdd = strings.get(j)+strings.get(i);
					if(!freq.containsKey(toAdd)) freq.put(toAdd, 1);
					else freq.put(toAdd, freq.get(toAdd)+1);
					String toAdd2 = strings.get(i)+strings.get(j);
					if(!toAdd.equals(toAdd2)) {
						if(!freq.containsKey(toAdd2)) freq.put(toAdd2, 1);
						else freq.put(toAdd2, freq.get(toAdd2)+1);
					}
				}
			for(int i: freq.values()) max = Math.max(max, i);
			for(String s: freq.keySet()) 
				if(freq.get(s)==max) {
					System.out.println(s);
					break;
				}
			if(nC>0) System.out.println();
		}
	}
}
