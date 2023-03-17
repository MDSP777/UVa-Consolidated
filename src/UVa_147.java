

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class UVa_147  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        float k=0;
        int m;
        int check = 0;
        int money[] = new int[11];
        BigInteger count[] = new BigInteger[30001];
        money[0] = 5;
        money[1] = 10;
        money[2] = 20;
        money[3] = 50;
        money[4] = 100;
        money[5] = 200;
        money[6] = 500;
        money[7] = 1000;
        money[8] = 2000;
        money[9] = 5000;
        money[10] = 10000;
        
        count[0] = BigInteger.valueOf(1);
        for(int j= 1; j < 30001 ; j++)
        {  
                count[j] = BigInteger.valueOf(0);
              
        }

        
        for(int i = 0 ; i< 11; i++)
        {
            for(int j= money[i]; j < 30001 ; j++)
            {  
                count[j] = count[j].add(count[j - money[i]]);
              
            }
        }
        
        while(check == 0)
        {
            k = sc.nextFloat();
            k *= 100;
            m = (int) Math.round(k);
            
            
            if(k == 0.00)
            {
                check =1;
            }

            if(check == 0)
            {
                if(k<=30000){
                    k/=100;
                    String l = k+"";
                    if(l.split("\\.")[1].length()==1) l+="0";
                    while(l.length()<6) l = " "+l;
                    String r = count[m].toString();
                    while(r.length()<17) r = " "+r;
                    System.out.println(l+r);
                }
                
            }
        }
        
    }
    
}
