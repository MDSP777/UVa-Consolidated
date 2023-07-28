import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Month;

public class UVa_12439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++){
			String[] s1 = br.readLine().replaceAll(",", "").split(" ");
			String[] s2 = br.readLine().replaceAll(",", "").split(" ");
			
			int m1 = Month.valueOf(s1[0].toUpperCase()).getValue();
			int m2 = Month.valueOf(s2[0].toUpperCase()).getValue();
			int d2 = Integer.parseInt(s2[1]);
			int y1 = Integer.parseInt(s1[2]);
			int y2 = Integer.parseInt(s2[2]);
			int total = 0;
			if(y1==y2){
				if(isLeapYear(y1) && m1<=2 && ((m2==2 && d2==29) || m2>2)) total++;
			} else {
				if(isLeapYear(y1) && m1<=2) total++;
				total+=countLeaps(y1+1, y2-1);
				if(isLeapYear(y2) && ((m2==2 && d2==29) || m2>2)) total++;
			}
			
			System.out.printf("Case %d: %d\n", t, total);
		}
	}
	
	static boolean isLeapYear(int y){
		return y%4==0 && (y%100!=0 || y%400==0);
	}
	
	static int countLeaps(int y1, int y2){
		if(y1>y2) return 0;
		if(y1==y2) return isLeapYear(y1) ? 1 : 0;
		
		y1--;
		int total = y2/4 - y1/4;
		total-= y2/100 - y1/100;
		total+= y2/400 - y1/400;

		return total;
	}
}
