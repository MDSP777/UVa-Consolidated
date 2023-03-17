import java.util.Scanner;

public class UVa_11309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			String[] split = sc.next().split(":");
			int[] curTime = new int[2];
			curTime[0] = Integer.parseInt(split[0]);
			curTime[1] = Integer.parseInt(split[1]);
			while(true) {
				curTime[1]++;
				if(curTime[1]==60) {
					curTime[1] = 0;
					curTime[0]++;
					if(curTime[0]==24) curTime[0] = 0;
				}
				if(palindrome(curTime)) {
					String s1 = curTime[0]+"";
					while(s1.length()!=2) s1 = "0"+s1;
					String s2 = curTime[1]+"";
					while(s2.length()!=2) s2 = "0"+s2;
					System.out.println(s1+":"+s2);
					break;
				}
			}
		}
	}

	private static boolean palindrome(int[] curTime) {
		String s = (curTime[0]>0 ? curTime[0]+"" : "")+(curTime[0]==0 ? curTime[1]+"" : (curTime[1]<10 ? "0"+curTime[1] : curTime[1]+""));
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}
