import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class UVa_815 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true){
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			if(r==0) break;

			int n = r*c;
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<r; i++){
				split = br.readLine().split(" ");
				for(int j=0; j<c; j++) arr.add(Integer.parseInt(split[j]));
			}
			Collections.sort(arr);
			
			double fill = Double.parseDouble(br.readLine());
			double curWaterHeight = arr.get(0);
			int regionSize = 1;
			while(fill>0){
				while(regionSize<n && arr.get(regionSize)==(int)curWaterHeight)
					regionSize++;
				if(regionSize<n){
					double targetHeight = arr.get(regionSize)-arr.get(regionSize-1);
					double waterNeeded = targetHeight*regionSize*100;
					if(fill>=waterNeeded){
						curWaterHeight+=targetHeight;
						fill-=waterNeeded;
						regionSize++;
					} else{
						curWaterHeight+=fill/(regionSize*100);
						break;
					}
				} else {
					curWaterHeight+=fill/(n*100);
					break;
				}
			}
			
			System.out.println("Region "+t++);
			System.out.printf("Water level is %.2f meters.\n", curWaterHeight);
			System.out.printf("%.2f percent of the region is under water.\n\n", regionSize*100.0/n);
		}
	}
}
