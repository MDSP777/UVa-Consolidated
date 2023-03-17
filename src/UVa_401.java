

import java.util.Scanner;

public class UVa_401 {
    static char[] mirrors = new char[100];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<100; i++) mirrors[i] = '$';
        mirrors['A'] = 'A';
        mirrors['E'] = '3';
        mirrors['H'] = 'H';
        mirrors['I'] = 'I';
        mirrors['J'] = 'L';
        mirrors['L'] = 'J';
        mirrors['M'] = 'M';
        mirrors['O'] = 'O';
        mirrors['S'] = '2';
        mirrors['T'] = 'T';
        mirrors['U'] = 'U';
        mirrors['V'] = 'V';
        mirrors['W'] = 'W';
        mirrors['X'] = 'X';
        mirrors['Y'] = 'Y';
        mirrors['Z'] = '5';
        mirrors['1'] = '1';
        mirrors['2'] = 'S';
        mirrors['3'] = 'E';
        mirrors['5'] = 'Z';
        mirrors['8'] = '8';
        do{
            String n = sc.next();
            boolean isPalin = isPalin(n);
            boolean isMirror = isMirror(n);
            if(isPalin && isMirror) System.out.println(n+" -- is a mirrored palindrome.\n");
            else if(isPalin) System.out.println(n+" -- is a regular palindrome.\n");
            else if(isMirror) System.out.println(n+" -- is a mirrored string.\n");
            else System.out.println(n+" -- is not a palindrome.\n");
        }while(sc.hasNext());
    }
    
    static boolean isPalin(String n){
        String n2 = "";
        for(int i=n.length()-1; i>=0; i--)
            n2+=n.charAt(i);
        if(n2.equals(n)) return true;
        return false;
    }
    
    static boolean isMirror(String n){
        String n2 = "";
        for(int i=n.length()-1; i>=0; i--)
            n2+=mirrors[n.charAt(i)];
        if(n2.equals(n)) return true;
        return false;
    }
}
