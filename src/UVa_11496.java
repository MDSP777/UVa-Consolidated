

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_11496 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            ArrayList<Integer> list = new ArrayList();
            for(int i=0; i<n; i++)
                list.add(sc.nextInt());
            int s = list.size();
            for(int i=1; i<s-1; i++){
                int a = list.get(i-1);
                int b = list.get(i);
                int c = list.get(i+1);
                if((a<b && b<c) || (a>b && b>c)){
                    list.remove(i);
                    i--;
                    s--;
                }
            }
            if(list.size()>=3){
                int a = list.get(list.size()-2);
                int b = list.get(list.size()-1);
                int c = list.get(0);
                if((a<b && b<c) || (a>b && b>c)) list.remove(list.size()-1);
            }
            
            if(list.size()>=3){
                int a = list.get(list.size()-1);
                int b = list.get(0);
                int c = list.get(1);
                if((a<b && b<c) || (a>b && b>c)) list.remove(0);
            }
            System.out.println(list.size());
            n = sc.nextInt();
        }
    }
}
