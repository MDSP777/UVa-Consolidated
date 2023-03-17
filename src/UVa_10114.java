import java.util.Scanner;

public class UVa_10114 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int nMonths = sc.nextInt();
			if(nMonths<0) break;
			double down = sc.nextDouble();
			double amt = sc.nextDouble();
			int nDep = sc.nextInt();
			double[] depVals = new double[nMonths+1];
			depVals[0] = 1;
			int curDepIndex = 0;
			for(int i=0; i<nDep; i++) {
				int month = sc.nextInt();
				double val = sc.nextDouble();
				for(int j=curDepIndex; j<month; j++) depVals[j] = depVals[curDepIndex];
				depVals[month] = 1-val;
				curDepIndex = month;
				if(i==nDep-1)
					for(int j=month+1; j<=nMonths; j++) depVals[j] = depVals[month];
			}
			System.out.println(solve(down, amt, depVals));
		}
	}

	private static String solve(double down, double amt, double[] depVals) {
		double carVal = down+amt;
		double costPerMonth = amt/(depVals.length-1);
		carVal *= depVals[0];
		if(amt<carVal) return "0 months";
		for(int i=1; i<depVals.length; i++) {
			amt -= costPerMonth;
			carVal *= depVals[i];
			if(amt<carVal) return i+(i==1 ? " month" : " months");
		}
		return null;
	}
}
