import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_12150 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<Car> cars = new ArrayList<>();
			boolean can = true;
			boolean[] used = new boolean[n];
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				Car c = new Car(Integer.parseInt(split[0]), Integer.parseInt(split[1]), i);
				if(c.o_index<0 || c.o_index>=n) can = false;
				else if(used[c.o_index]) can = false;
				else used[c.o_index] = true;
				cars.add(c);
			}
			if(can) {
				Collections.sort(cars);
				sb.append(cars.get(0).val);
				for(int i=1; i<cars.size(); i++) sb.append(" ").append(cars.get(i).val);
			} else sb.append("-1");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class Car implements Comparable<Car> {
		int val;
		int posLost;
		int curIndex;
		int o_index;
		
		public Car(int v, int p, int c) {
			val = v;
			posLost = p;
			curIndex = c;
			o_index = curIndex+posLost;
		}

		@Override
		public int compareTo(Car o) {
			return Integer.compare(this.o_index, o.o_index);
		}
	}
}
