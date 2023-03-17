
public class UVa_11236 {
	public static void main(String[] args) {
		int CAP = 2000000000;
		for(long A=1; A<=2000 && A*A*A*A<=CAP; A++)
			for(long B=A; B<=2000-A && A*B*B*B<=CAP; B++)
				for(long C=B; C<=2000-A-B && A*B*C*C<=CAP; C++){
					long x = A+B+C;
					long y = A*B*C;
					if(y-1000000!=0 && (1000000*x)%(y-1000000)==0){
						long D = (1000000*x)/(y-1000000);
						if(D>=C && D>=0 && A+B+C+D<=2000 && A*B*C*D<=CAP && 1000000*(A+B+C+D)==A*B*C*D) {
							System.out.printf("%d.%02d %d.%02d %d.%02d %d.%02d\n", A/100, A%100, B/100, B%100, C/100, C%100, D/100, D%100);
						}
					}
				}
	}
}
