import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class UVa_10509 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		TreeMap<Double, Double> cubes = new TreeMap<>();
		for(double i=1; i<=100; i++) cubes.put(i*i*i, i);
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) break;
			double n = Double.parseDouble(s);
			if(n<1) break;
			double a = cubes.get(cubes.floorKey(n));
			
			sb.append(String.format("%.4f\n", a+(n-a*a*a)/(3*a*a)));
		}
		System.out.print(sb);
	}
}
