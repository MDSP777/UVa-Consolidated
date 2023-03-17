import java.util.Scanner;


public class UVa_11565 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			boolean sol = false;
			for(int x=-100; !sol && x<=100; x++)
				for(int y=-100; !sol && y<=100; y++)
					for(int z=-100; !sol && z<=100; z++)
						if(x!=y && y!=z && x!=z &&
							x+y+z==a && x*y*z==b && x*x+y*y+z*z==c) {
							sol = true;
							System.out.println(x+" "+y+" "+z);
						}
			if(!sol) System.out.println("No solution.");
		}
	}
}
