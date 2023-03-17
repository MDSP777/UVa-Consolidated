

import java.util.Scanner;

public class UVa_12289 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long nC = sc.nextLong();
        sc.nextLine();
        for(long i=0; i<nC; i++){
            String n = sc.nextLine();
            if(n.length()==5) System.out.println("3");
            else{
                if(n.equals("one")) System.out.println("1");
                else if(n.equals("two")) System.out.println("2");
                else{
                    if(n.charAt(0)!='o'){
                        if(n.charAt(1)=='n'&&n.charAt(2)=='e') System.out.println("1");
                        else System.out.println("2");
                    }
                    else if(n.charAt(1)!='n'){
                        if(n.charAt(0)=='o'&&n.charAt(2)=='e') System.out.println("1");
                        else System.out.println("2");
                    }
                    else if(n.charAt(2)!='e'){
                        if(n.charAt(0)=='o'&&n.charAt(1)=='n') System.out.println("1");
                        else System.out.println("2");
                    }
                    else System.out.println("2");
                }
            }
        }
    }
}
