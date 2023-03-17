import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_11917 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int nSubj = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			while(nSubj-->0) {
				String[] split = br.readLine().split("\\s+");
				map.put(split[0], Integer.parseInt(split[1]));
			}
			int d = Integer.parseInt(br.readLine());
			String subj = br.readLine();
			if(!map.containsKey(subj) || map.get(subj)-d>5) System.out.println("Case "+x+": Do your own homework!");
			else if(map.get(subj)<=d) System.out.println("Case "+x+": Yesss");
			else System.out.println("Case "+x+": Late");
		}
	}
}
