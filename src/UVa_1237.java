import java.util.Scanner;

public class UVa_1237 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int nCars = sc.nextInt();
			Car[] cars = new Car[nCars];
			for(int i=0; i<nCars; i++) cars[i] = new Car(sc.next(), sc.nextInt(), sc.nextInt());
			int nQ = sc.nextInt();
			while(nQ-->0) {
				int p = sc.nextInt();
				boolean found = false;
				String n = "UNDETERMINED";
				for(Car c: cars)
					if(p>=c.min && p<=c.max) {
						if(!found) {
							n = c.name;
							found = true;
						} else {
							n = "UNDETERMINED";
							break;
						}
					}
				System.out.println(n);
			}
			if(nC>0) System.out.println();
		}
	}
	
	static class Car {
		String name;
		int min;
		int max;
		
		public Car(String n, int m1, int m2) {
			name = n;
			min = m1;
			max = m2;
		}
	}
}
