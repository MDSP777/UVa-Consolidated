import java.util.Scanner;


public class UVa_607 {
	static int n;
	static int l;
	static int c;
	static int[] lectures;
	static Answer[][] memo;
	static Answer INITIAL = new Answer(10000000, 0);
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		boolean first = true;
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			if(first) first = false;
			else System.out.println();
			l = sc.nextInt();
			c = sc.nextInt();
			lectures = new int[n];
			for(int i=0; i<n; i++) lectures[i] = sc.nextInt();
			memo = new Answer[n][l+1];
			Answer a = dp(0, l);
			System.out.println("Case "+t+++":\nMinimum number of lectures: "+a.n+"\nTotal dissatisfaction index: "+a.d);
		}
	}
	
	static Answer dp(int index, int remTime){
		if(index==n) return new Answer(1, calcD(remTime));
		if(memo[index][remTime]!=null) return memo[index][remTime];
		Answer ans = INITIAL;
		Answer temp = INITIAL;
		if(remTime<l) {
			Answer x = dp(index, l);
			temp = new Answer(x.n, x.d);
			temp.n++;
			temp.d+=calcD(remTime);
		}
		ans = best(ans, temp);
		if(remTime-lectures[index]>=0){
			temp = dp(index+1, remTime-lectures[index]);
			ans = best(ans, temp);
		}
		if(memo[index][remTime]==null) memo[index][remTime] = ans;
		return ans;
	}
	
	static int calcD(int t){
		if(t==0) return 0;
		if(t>=1 && t<=10) return -c;
		return (t-10)*(t-10);
	}
	
	static Answer best(Answer a, Answer b){
		if(a==null) return b;
		if(b==null) return a;
		return (a.n<b.n || (a.n==b.n && a.d<b.d)) ? a : b;
	}
	
	static class Answer {
		int n, d;
		
		Answer(int a, int b){
			n = a;
			d = b;
		}
		
		public String toString(){
			return n+" "+d;
		}
	}
	
}
