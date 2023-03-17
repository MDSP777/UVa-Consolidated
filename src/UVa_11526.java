import java.util.Scanner;

public class UVa_11526 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
//        int tc = 1000;
        while(tc-->0){
        	int n = sc.nextInt();
//        	int n = tc;
        	int sqrt = (int)Math.sqrt(n);
        	long upper = 0, lower = 0;
        	
        	for(int i=1; i<=sqrt; i++){
        		upper += n/i;
        	}
        	int missing = n-sqrt;
        	int addedLower = 0;
//        	System.out.println("upper "+upper);
        	for(int i=1; i<sqrt; i++){
    			lower += (n/i - n/(i+1))*i;
    			addedLower += (n/i - n/(i+1));
        	}
        	while(addedLower<missing){
        		lower += n/(n-addedLower);
        		addedLower++;
        	}
        	System.out.println(upper+lower);
//        	long actual = upper+lower;
//        	long expected = H(n);
//        	System.out.println("E: "+expected+" A: "+actual);
//        	if(expected!=actual) throw new Exception(n+"");
        }
    }
    
    static long H(int n){
		long total = 0;
		for(int i=1; i<=n; i++) total+=n/i;
		return total;
	}
}