

import java.util.Scanner;

public class UVa_11650 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            String in = sc.nextLine();
            int h = new Integer(in.split(":")[0]);
            int m = new Integer(in.split(":")[1]);
            if(h==12) h=0;
            if(m==0){
                String hout = Math.abs(12-h)+"";
                if(hout.length()==1) hout = "0"+hout;
                System.out.println(hout+":00");
            }
            else{
                h = 11-h;
                if(h==0) h = 12;
                m = Math.abs(60-m);
                String mout = m+"";
                String hout = h+"";
                if(hout.length()==1) hout = "0"+hout;
                if(mout.length()==1) mout = "0"+mout;
                System.out.println(hout+":"+mout);
            }
        }

    }
}
