

import java.util.Scanner;

public class UVa_10921 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num;
        do{
            num=sc.next();
            for(int i=0; i<num.length(); i++){
                if(num.charAt(i)=='-')
                    System.out.print("-");
                else
                    System.out.print(getNum(num.charAt(i)));
            }
            System.out.println();
        }while(sc.hasNext());
    }
    
    public static int getNum(char a){
        if(a=='1')
            return 1;
        else if(a=='0')
            return 0;
        else if(a<='C')
            return 2;
        else if(a<='F')
            return 3;
        else if(a<='I')
            return 4;
        else if(a<='L')
            return 5;
        else if(a<='O')
            return 6;
        else if(a<='S')
            return 7;
        else if(a<='V')
            return 8;
        else return 9;
    }
}
