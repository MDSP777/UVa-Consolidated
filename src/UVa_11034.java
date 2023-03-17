import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_11034 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int len = Integer.parseInt(split[0])*100;
			int nCars = Integer.parseInt(split[1]);
			LinkedList<Integer>[] banks = new LinkedList[2];
			for(int i=0; i<2; i++) banks[i] = new LinkedList<>();
			while(nCars-->0) {
				split = br.readLine().split("\\s+");
				banks[split[1].equals("left") ? 0 : 1].add(Integer.parseInt(split[0]));
			}
			int crosses = 0;
			int side = 0;
			int curCapacity = 0;
			while(!banks[0].isEmpty() || !banks[1].isEmpty()) {
				while(!banks[side].isEmpty() && curCapacity+banks[side].peek()<=len) curCapacity+=banks[side].poll();
				crosses++;
				side = (side+1)%2;
				curCapacity = 0;
			}
			System.out.println(crosses);
		}
	}
}
