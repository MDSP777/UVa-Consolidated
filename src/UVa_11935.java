import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_11935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals("0 Fuel consumption 0")) break;
			ArrayList<String> instructions = new ArrayList<>();
			instructions.add(s);
			while(true){
				s = br.readLine();
				instructions.add(s);
				if(s.endsWith("Goal")) break;
			}
			float l = 0;
			float h = 10000;
			float ans = 10000;
			for(int i=0; i<50; i++){
				float m = (h+l)/2;
				if(can(instructions, m)){
					ans = m;
					h = m;
				} else l = m;
			}
			System.out.printf("%.3f\n", ans);
		}
	}
	
	static boolean can(ArrayList<String> instructions, float fuel){
		int pos = 0;
		int leaks = 0;
		int rate = Integer.parseInt(instructions.get(0).split(" Fuel consumption ")[1]);
		float curFuel = fuel;
		for(int i=1; i<instructions.size(); i++){
			String s = instructions.get(i);
			int newPos = Integer.parseInt(s.split(" ")[0]);
			curFuel-=(float)(newPos-pos)/100.0*rate;
			curFuel-=leaks*(newPos-pos);
			if(curFuel<0) return false;
			if(s.endsWith("Mechanic")) leaks = 0;
			else if(s.endsWith("Leak")) leaks++;
			else if(s.endsWith("Gas station")) curFuel = fuel;
			else if(s.contains("Fuel")) rate = Integer.parseInt(s.split(" Fuel consumption ")[1]);
			pos = newPos;
		}
		return true;
	}
}
