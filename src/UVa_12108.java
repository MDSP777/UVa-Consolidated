import java.util.Scanner;

public class UVa_12108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int[] a = new int[n];
			int[] b = new int[n];
			int[] curStates = new int[n];
			int[] initialStates = new int[n];
			for(int i=0; i<n; i++){
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
				int c = sc.nextInt();
				initialStates[i] = c;
				curStates[i] = initialStates[i];
			}
			
			int matched = 0;
			int time = 1;
			while(true){
				boolean m = true;
				for(int i=0; i<n; i++)
					m&=curStates[i]==initialStates[i];
				if(m) matched++;
				if(matched==2) {
					System.out.println("Case "+tc+++": -1");
					break;
				}
				
				int sleep = 0;
				for(int i=0; i<n; i++)
					sleep+=curStates[i]<=a[i] ? 0 : 1;
				if(sleep==0) {
					System.out.println("Case "+tc+++": "+time);
					break;
				}
				
				for(int i=0; i<n; i++){
					if(curStates[i]==a[i] && sleep<=n-sleep)
						curStates[i] = 1;
					else if(curStates[i]==a[i]+b[i])
						curStates[i] = 1;
					else
						curStates[i]++;
				}
				
				time++;
			}
		}
	}
	
	static class State{
		boolean isAwake;
		int ctr;
		
		State(boolean a, int b){
			isAwake = a;
			ctr = b;
		}
		
		public boolean equals(State o){
			return isAwake==o.isAwake && ctr==o.ctr;
		}
	}
}
