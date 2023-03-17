import java.util.Scanner;

public class UVa_12291 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			char[][] big = new char[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) big[i][j] = '.';
				char[] c = sc.next().toCharArray();
				for(int j=0; j<c.length; j++) big[i][j] = c[j];
			}
			char[][] small = new char[m][m];
			for(int i=0; i<m; i++) {
				for(int j=0; j<m; j++) small[i][j] = '.';
				char[] c = sc.next().toCharArray();
				for(int j=0; j<c.length; j++) small[i][j] = c[j];
			}
			System.out.println(check(big, small, n, m));
		}
	}
	
	static int check(char[][] big, char[][] small, int n, int m) {
		for(int i1=-m+1; i1<n; i1++)
			for(int j1=-m+1; j1<n; j1++) {
				char[][] bigCopy = new char[n][n];
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) bigCopy[i][j] = big[i][j];
				boolean can = true;
				for(int i=i1; can && i<i1+m; i++)
					for(int j=j1; can && j<j1+m; j++) {
						if(i<0 || i>=n || j<0 || j>=n) {
							if(small[i-i1][j-j1]=='*') can = false;
							continue;
						}
						if(small[i-i1][j-j1]=='*') {
							if(bigCopy[i][j]=='*') bigCopy[i][j] = '.';
							else can = false;
						}
					}
				if(can) {
					for(int i2=-m+1; i2<n; i2++)
						for(int j2=-m+1; j2<n; j2++) {
							char[][] bigCopy2 = new char[n][n];
							for(int i=0; i<n; i++)
								for(int j=0; j<n; j++) bigCopy2[i][j] = bigCopy[i][j];
							can = true;
							for(int i=i2; can && i<i2+m; i++)
								for(int j=j2; can && j<j2+m; j++) {
									if(i<0 || i>=n || j<0 || j>=n) {
										if(small[i-i2][j-j2]=='*') can = false;
										continue;
									}
									if(small[i-i2][j-j2]=='*') {
										if(bigCopy2[i][j]=='*') bigCopy2[i][j] = '.';
										else can = false;
									}
								}
							if(can) {
								boolean s = true;
								for(int i=0; i<n; i++)
									for(int j=0; j<n; j++) s&=bigCopy2[i][j]=='.';
								if(s) return 1;
							}
						}
				}
			}
		return 0;
	}
}
