

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10260 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String n = sc.nextLine();
            ArrayList<Integer> a = new ArrayList();
            for(int i=0; i<n.length(); i++){
                char c = n.charAt(i);
                switch(c){
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'H':
                    case 'W':
                    case 'Y': a.add(0); break;
                    case 'B':
                    case 'F':
                    case 'P':
                    case 'V': a.add(1); break;
                    case 'C':
                    case 'G':
                    case 'J':
                    case 'K':
                    case 'Q':
                    case 'S':
                    case 'X':
                    case 'Z': a.add(2); break;
                    case 'D':
                    case 'T': a.add(3); break;
                    case 'L': a.add(4); break;
                    case 'M':
                    case 'N': a.add(5); break;
                    case 'R': a.add(6); break;
                }
            }
            for(int ii=1; ii<a.size(); ii++)
                if(a.get(ii-1)==a.get(ii)){
                    a.remove(ii);
                    ii--;
                }
            for(int ii=0; ii<a.size(); ii++)
                if(a.get(ii)!=0)
                    System.out.print(a.get(ii));
            System.out.println("");
        }while(sc.hasNext());
    }
}
