import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			LinkedList<Integer> l = new LinkedList<>();
			for(int i=1; i<=n; i++) l.add(i);
			ArrayList<Integer> thrown = new ArrayList<>();
			while(l.size()>1) {
				thrown.add(l.poll());
				l.add(l.poll());
			}
			System.out.print("Discarded cards:");
			if(thrown.size()>0) {
				System.out.print(" "+thrown.get(0));
				for(int i=1; i<thrown.size(); i++) System.out.print(", "+thrown.get(i));
			}
			System.out.println();
			System.out.println("Remaining card: "+l.peek());
		}
	}
}
