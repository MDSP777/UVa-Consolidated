

import java.util.Scanner;
import java.util.Stack;

public class UVa_673 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<nC; i++){
            boolean flag = true;
            String n = sc.nextLine();
            Stack<Character> s = new Stack();
            int l = n.length();
            for(int j=0; j<l; j++){
                char c = n.charAt(j);
                if(c=='('||c=='[') s.push(c);
                else if(s.size()==0){
                    flag = false; break;
                }
                else if((c==')'&&s.peek()=='(')||(c==']'&&s.peek()=='[')) s.pop();
                else{
                    flag = false; break;
                }
            }
            if(flag && s.size()==0) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
