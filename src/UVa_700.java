import java.util.ArrayList;
import java.util.Scanner;

public class UVa_700 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] display = new int[25];
		int[] a = new int[25];
		int[] b = new int[25];
		int t = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			for(int i=0; i<n; i++){
				display[i] = sc.nextInt();
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			ArrayList<Integer> possibleYears = new ArrayList<>();
			int y = display[0];
			while(y<10000){
				possibleYears.add(y);
				y+=b[0]-a[0];
			}
			int ans = -1;
			for(int year: possibleYears){
				boolean yes = true;
				for(int i=1; yes && i<n; i++){
					int diff = b[i]-a[i];
					if(year<a[i]){
						yes = false;
						break;
					}
					int actualYear = (year-a[i])%diff+a[i];
					if(actualYear!=display[i]) yes = false;
				}
				if(yes){
					ans = year;
					break;
				}
			}
			System.out.println("Case #"+t+++":");
			System.out.println(ans==-1 ? "Unknown bugs detected.\n" : "The actual year is "+ans+".\n");
		}
	}
}
