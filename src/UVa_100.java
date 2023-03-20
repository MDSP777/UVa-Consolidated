/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, j;
        do{
            int max = Integer.MIN_VALUE;
            i = sc.nextInt();
            j = sc.nextInt();
            System.out.print(i+" "+j+" ");
            if(i>j){
                int temp = j;
                j = i;
                i = temp;
            }
            for(int a=i; a<=j; a++){
                int num = a;
                int cur = doShit(a);
                if(cur>max)
                    max = cur;
            }
            System.out.println(max);
        }while(sc.hasNext());
    }
    
    public static int doShit(int a){
        long shit = a;
        int ctr = 1;
        while(shit!=1){
            if(shit%2==0){
                shit/=2;
            }
            else{
                shit*=3;
                shit++;
            }
            ctr++;
        }
        return ctr;
    }
}
