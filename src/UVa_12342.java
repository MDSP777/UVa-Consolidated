

import java.util.Scanner;

public class UVa_12342 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder("");
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            double tax = 0;
            double money = sc.nextDouble();
            if(money<=180000) tax = 0;
            else{
                money -= 180000;
                if(money <= 300000) tax += money*0.1; 
                else{
                    money -= 300000;
                    tax+=300000*0.1;
                    if(money <= 400000) tax += money*0.15;
                    else{
                        money -= 400000;
                        tax+=400000*0.15;
                        if(money <= 300000) tax += money*0.2;
                        else{
                            money -= 300000;
                            tax += 300000*0.2;
                            if(money >= 0)
                            tax += money * 0.25;
                        }
                    }
                }
            }
            if(tax>0 && tax < 2000) out.append("Case "+x+": 2000\n");
            else out.append("Case "+x+": "+(int)Math.ceil(tax)+"\n");
        }
        System.out.print(out);
    }
}
