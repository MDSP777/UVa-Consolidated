

import java.util.Scanner;

public class UVa_10035 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(), b=sc.nextInt();
        String sA, sB;
        int nCarry, carryVal, longerS, shorterS, e, sum;
        char l;
        while(a!=0 || b!=0){
            carryVal=0;
            nCarry=0;
            sA = String.valueOf(a);
            sB = String.valueOf(b);
            if(sA.length()>sB.length()){
                longerS = sA.length();
                shorterS = sB.length();
                l = 'a';
            }
            else{
                longerS = sB.length();
                shorterS = sA.length();
                l = 'b';
            }
            e=shorterS-1;
            for(int i=longerS-1; i>=0; i--){  
                if(l=='a'){
                    if(e>=0){
                        sum = carryVal + (sA.charAt(i)-48)+(sB.charAt(e)-48);
                        e--;
                    }
                    else
                        sum = carryVal + (sA.charAt(i)-48);
                    carryVal = sum/10;
                    if(carryVal==1){
                        nCarry++;
                    } 
                }
                else if(l=='b'){
                    if(e>=0){
                        sum = carryVal + (sB.charAt(i)-48)+(sA.charAt(e)-48);
                        e--;
                    }
                    else
                        sum = carryVal + (sB.charAt(i)-48);
                    carryVal = sum/10;
                    if(carryVal==1){
                        nCarry++;
                    }
                }
            }
            if(nCarry==1)
                System.out.println("1 carry operation.");
            else if(nCarry==0)
                System.out.println("No carry operation.");
            else
                System.out.println(nCarry + " carry operations.");
            a=sc.nextInt();
            b=sc.nextInt();
        }
    } 
}
