import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10431 {
	static double sqrt2pi = Math.sqrt(2*Math.PI);
	static double b1 = 0.319381530;
	static double b2 = -0.356563782;
	static double b3 = 1.781477937;
	static double b4 = -1.821255978;
	static double b5 = 1.330274429;
	static double p = 0.2316419;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		boolean first = true;
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			
			// problem statement does not mention it but a blank line is needed between TCs
			if(first) first = false;
			else sb.append("\n");
			
			int n = Integer.parseInt(s);
			double[] arr = new double[n];
			String[] split = br.readLine().split(" ");
			double mean = 0;
			for(int i=0; i<n; i++){
				arr[i] = Double.parseDouble(split[i]);
				mean+=arr[i];
			}
			mean/=n;
			double stdev = 0;
			for(int i=0; i<n; i++) stdev+=Math.pow(arr[i]-mean, 2);
			stdev = Math.sqrt(stdev/(n-1));
			
			sb.append("Data Set #").append(tc++).append("\n");
			sb.append(String.format("Mean = %.4f\n", mean));
			sb.append(String.format("Standard Deviation = %.4f\n", stdev));
			
			br.readLine();
			split = br.readLine().split(" ");
			for(int i=0; i<split.length; i++){
				double x = Double.parseDouble(split[i]);
				double z = (x-mean)/stdev;
				double t = 1.0/(1+p*Math.abs(z));
				double q = q(z, t);
				double p = 1-q;
				sb.append(String.format("P(z) = %.4f, Q(z) = %.4f, T = %.4f\n", p, q, n*q));
			}
		}
		System.out.print(sb);
	}
	
	// problem statement formula is wrong, the operator between b2 and b3 should still be +, not *
	// also theta is irrelevant
	static double q(double z, double t){
		return f(z)*(b1*t + b2*t*t + b3*t*t*t + b4*t*t*t*t + b5*t*t*t*t*t);
	}
	
	// problem statement formula is wrong, e power should be -x^2/2, not positive
	static double f(double x){
		return (1.0/sqrt2pi)*Math.exp(-x*x/2);
	}
}
