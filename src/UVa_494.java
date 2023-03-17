

import java.util.Scanner;

public class UVa_494 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            long total = 0;
            String n = sc.nextLine();
            int s = n.length();
            boolean flag = false;
            for(int i=0; i<s; i++){
                char c = n.charAt(i);
                if(!flag && isLetter(c)){
                    total++;
                    flag = true;
                }
                else if(flag && !isLetter(c)){
                    flag = false;
                }
            }
            System.out.println(total);
        }while(sc.hasNext());

    }
    
    public static boolean isLetter(char c){
        if((c>=65 && c<=90)||(c>=97&&c<=122))
            return true;
        return false;
    }
}
