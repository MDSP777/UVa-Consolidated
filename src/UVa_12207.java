

import java.util.LinkedList;
import java.util.Scanner;

public class UVa_12207 {
    public static void main(String[] args){
        int nc = 1;
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int c = sc.nextInt();
            if(n==0 && c==0) break;
            LinkedList<Integer> ll = new LinkedList();
            int bound = Math.min(n, c);
            for(int i=0; i<bound; i++)
                ll.add(i+1);
            System.out.println("Case "+nc+++":");
            for(int i=0; i<c; i++){
                char command = sc.next().charAt(0);
                if(command=='N'){
                    System.out.println(ll.peek());
                    ll.add(ll.remove());
                }else{
                    int index = sc.nextInt();
                    ll.remove(new Integer(index));
                    ll.addFirst(index);
                }
            }
        }

    }
}
