import java.util.Scanner;


public class UVa_12696 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int total = 0;
		while(tc-->0){
			double len = sc.nextDouble();
			double wid = sc.nextDouble();
			double dep = sc.nextDouble();
			double wgt = sc.nextDouble();
			boolean y = ((len<=56 && wid<=45 && dep<=25) || len+wid+dep<=125) && wgt<=7.0;
			if(y) total++;
			System.out.println(y ? 1 : 0);
		}
		System.out.println(total);
	}
}
