

import java.util.Scanner;

public class UVa_10082 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String n = sc.nextLine();
            shit(n);
        }while(sc.hasNext());
    }
    
    public static void shit(String n){
        StringBuilder out = new StringBuilder();
        int l = n.length();
        for(int i=0; i<l; i++){
            char c = '@';
            switch(n.charAt(i)){
                case 'S': c = 'A'; break;
                case 'D': c = 'S'; break;
                case 'F': c = 'D'; break;
                case 'G': c = 'F'; break;
                case 'H': c = 'G'; break;
                case 'J': c = 'H'; break;
                case 'K': c = 'J'; break;
                case 'L': c = 'K'; break;
                case ';': c = 'L'; break;
                case 39: c = ';'; break;
                case 'W': c = 'Q'; break;
                case 'E': c = 'W'; break;
                case 'R': c = 'E'; break;
                case 'T': c = 'R'; break;
                case 'Y': c = 'T'; break;
                case 'U': c = 'Y'; break;
                case 'I': c = 'U'; break;
                case 'O': c = 'I'; break;
                case 'P': c = 'O'; break;
                case '[': c = 'P'; break;
                case ']': c = '['; break;
                case 92: c = ']'; break;
                case 'X': c = 'Z'; break;
                case 'C': c = 'X'; break;
                case 'V': c = 'C'; break;
                case 'B': c = 'V'; break;
                case 'N': c = 'B'; break;
                case 'M': c = 'N'; break;
                case ',': c = 'M'; break;
                case '.': c = ','; break;
                case '/': c = '.'; break;
                case '1': c = '`'; break;
                case '2': c = '1'; break;
                case '3': c = '2'; break;
                case '4': c = '3'; break;
                case '5': c = '4'; break;
                case '6': c = '5'; break;
                case '7': c = '6'; break;
                case '8': c = '7'; break;
                case '9': c = '8'; break;
                case '0': c = '9'; break;
                case '-': c = '0'; break;
                case '=': c = '-'; break;
                case ' ': c = ' '; break;
            }
            out.append(c);
        }
        System.out.println(out);
    }
}
