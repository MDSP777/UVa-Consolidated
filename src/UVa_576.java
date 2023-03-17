

import java.util.Scanner;

public class UVa_576 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String n = sc.nextLine();
            if(n.equals("e/o/i")) break;
            String[] split = n.split("/");
            int[] syl = {5, 7, 5};
            int total;
            boolean flag = true;
            for(int i=0; i<3; i++){
                total = 0;
                String cur = split[i];
                for(int j=0; j<cur.length(); j++){
                    char c = cur.charAt(j);
                    if(isVowel(c)){
                        total++;
                        j++;
                        while(isVowel(c) && j<cur.length()){
                            c = cur.charAt(j);
                            j++;
                        }
                        j--;
                    }
                }
                if(total!=syl[i]){
                    System.out.println(i+1);
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("Y");
        }
    }
    
    static boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y': return true;
        }
        return false;
    }
}
