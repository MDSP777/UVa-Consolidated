import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_154 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals("#")) break;
			ArrayList<City> cities = new ArrayList<>();
			cities.add(new City(s));
			while(true){
				s = br.readLine();
				if(s.startsWith("e")) break;
				cities.add(new City(s));
			}
			int min = 1000000000;
			int ans = -1;
			for(int i=0; i<cities.size(); i++){
				int cur = 0;
				for(int j=0; j<cities.size(); j++)
					for(int k=0; k<5; k++) if(cities.get(i).vals[k]!=cities.get(j).vals[k]) cur++;
				if(cur<min){
					min = cur;
					ans = i+1;
				}
			}
			System.out.println(ans);
		}
	}
	
	static class City{
		char[] vals; // 0 - r, 1 - o , 2 - y, 3 - g, 4 - b
		
		City(String s){
			String[] split = s.split(",");
			vals = new char[5];
			for(int i=0; i<5; i++) {
				char x = split[i].charAt(0);
				vals[x=='r' ? 0 : x=='o' ? 1 : x=='y' ? 2 : x=='g' ? 3 : 4] = split[i].charAt(2);
			}
		}
	}
}
