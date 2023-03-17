import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class UVa_11860 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++){
			ArrayList<String> doc = new ArrayList<>();
			HashSet<String> words = new HashSet<>();
			boolean done = false;
			while(!done){
				String s = br.readLine();
				s = s.replaceAll("[^a-zEND ]", " ").trim();
				String[] split = s.split("\\s+");
				for(String cur: split){
					if(cur.equals("END")) {
						done = true;
						break;
					}
					if(cur.matches("[a-z]+")){
						doc.add(cur);
						words.add(cur);
					}
				}
			}
			int i = 1;
			HashMap<String, Integer> map = new HashMap<>();
			TreeSet<Integer> indices = new TreeSet<>();
			map.put(doc.get(0), 0);
			indices.add(0);
			while(map.size()<words.size()){
				if(map.containsKey(doc.get(i))) indices.remove(map.get(doc.get(i)));
				indices.add(i);
				map.put(doc.get(i), i);
				i++;
			}
			Answer ans = new Answer(indices.first(), indices.last());
			while(i<doc.size()){
				indices.remove(map.get(doc.get(i)));
				indices.add(i);
				map.put(doc.get(i), i);
				Answer newAns = new Answer(indices.first(), indices.last());
				if(newAns.diff()<ans.diff()) ans = newAns;
				i++;
			}
			System.out.printf("Document %d: %d %d\n", t, ans.start+1, ans.end+1);
		}
	}
	
	static class Answer {
		int start;
		int end;
		
		public Answer(int s, int e){
			start = s;
			end = e;
		}
		
		int diff(){
			return end-start;
		}
	}
}
