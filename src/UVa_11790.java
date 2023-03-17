import java.util.Scanner;

public class UVa_11790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int curC=1; curC<=nC; curC++) {
			int n = sc.nextInt();
			Building[] buildings = new Building[n];
			for(int i=0; i<n; i++) buildings[i] = new Building(sc.nextInt());
			for(int i=0; i<n; i++) buildings[i].w = sc.nextInt();
			Building[] buildingsRev = new Building[n];
			int[] dp1 = new int[n];
			int[] dp2 = new int[n];
			int incMax = 0;
			int decMax = 0;
			for(int i=0; i<n; i++) {
				buildingsRev[i] = new Building(buildings[n-1-i].h);
				buildingsRev[i].w = buildings[n-1-i].w;
				dp1[i] = buildings[i].w;
				dp2[i] = buildingsRev[i].w;
				incMax = Math.max(incMax, buildings[i].w);
				decMax = Math.max(decMax, buildingsRev[i].w);
			}
			for(int i=0; i<n; i++) 
				for(int j=0; j<i; j++) {
					if(buildings[j].h<buildings[i].h && dp1[j]+buildings[i].w>dp1[i]) {
						dp1[i] = dp1[j]+buildings[i].w;
						incMax = Math.max(incMax, dp1[i]);
					}
					if(buildingsRev[j].h<buildingsRev[i].h && dp2[j]+buildingsRev[i].w>dp2[i]) {
						dp2[i] = dp2[j]+buildingsRev[i].w;
						decMax = Math.max(decMax, dp2[i]);
					}
				}
			if(incMax>=decMax) System.out.println("Case "+curC+". Increasing ("+incMax+"). Decreasing ("+decMax+").");
			else System.out.println("Case "+curC+". Decreasing ("+decMax+"). Increasing ("+incMax+").");
		}
	}
	
	static class Building {
		int h;
		int w;
		
		public Building(int h) {
			this.h = h;
		}
	}
}
