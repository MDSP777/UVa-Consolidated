import java.util.Scanner;

public class UVa_11877 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int nCoke = 0;
            while(n>=3){
                nCoke += n/3;
                int temp = n/3;
                n %= 3;
                n += temp;
            }
            if(n==2) nCoke++;
            System.out.println(nCoke);
        }
    }
}
