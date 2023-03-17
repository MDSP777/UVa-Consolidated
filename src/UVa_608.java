import java.util.Scanner;

public class UVa_608 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		sc.nextLine();
		while(nC-->0) {
			String[] inputs = new String[3];
			for(int i=0; i<3; i++) inputs[i] = sc.nextLine();
			System.out.println(solve(inputs));
		}
	}

	private static String solve(String[] inputs) {
		for(int i='A'; i<='L'; i++) {
			if(found(i, 2, inputs)) return format(i, 1);
			else if(found(i, -2, inputs)) return format(i, -1);	
		}
		return null;
	}	
	
	private static boolean found(int c, int val, String[] inputs) {
		for(int i=0; i<3; i++) {
			String[] split = inputs[i].split(" ");
			int leftSum = 0;
			int rightSum = 0;
			for(int j=0; j<split[0].length(); j++)
				leftSum += split[0].charAt(j)==c ? val : 1;
			for(int j=0; j<split[1].length(); j++)
				rightSum += split[1].charAt(j)==c ? val : 1;
			if((split[2].equals("even") && leftSum!=rightSum) ||
				(split[2].equals("up") && rightSum>=leftSum) ||
				(split[2].equals("down") && rightSum<=leftSum)) return false;
		}
		return true;
	}

	private static String format(int coin, int val) {
		return ((char)coin)+" is the counterfeit coin and it is "+(val==-1 ? "light" : "heavy")+".";
	}
}
