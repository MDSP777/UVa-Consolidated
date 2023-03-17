import java.util.Scanner;

public class UVa_133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && k==0 && m==0) break;
			int curK = -1;
			int curM = 0;
			String s = "";
			boolean[] people = new boolean[n];
			while(!allSelected(people)) {
				int kCtr = 0;
				int mCtr = 0;
				while(kCtr<k) {
					curK++;
					if(curK==n) curK = 0;
					while(people[curK]) {
						curK++;
						if(curK==n) curK = 0;
					}
					kCtr++;
				}
				while(mCtr<m) {
					curM--;
					if(curM==-1) curM = n-1;
					while(people[curM]) {
						curM--;
						if(curM==-1) curM = n-1;
					}
					mCtr++;
				}
				people[curK] = people[curM] = true;
				String kOut = (curK+1)+"";
				while(kOut.length()<3) kOut = " "+kOut;
				String mOut = (curM+1)+"";
				while(mOut.length()<3) mOut = " "+mOut;
				if(curK==curM) s += kOut+",";
				else s += kOut+mOut+",";
			}
			System.out.println(s.substring(0, s.length()-1));
		}
	}

	private static boolean allSelected(boolean[] people) {
		for(int i=0; i<people.length; i++) if(!people[i]) return false;
		return true;
	}
}
