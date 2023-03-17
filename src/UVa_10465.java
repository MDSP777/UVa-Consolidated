

import java.util.Scanner;

public class UVa_10465 {
    static int b1;
    static int b2;
    static int min;
    static int max;
    static Ans[] memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            b1 = sc.nextInt();
            b2 = sc.nextInt();
            min = Math.min(b1, b2);
            max = Math.max(b1, b2);
            int time = sc.nextInt();
            memo = new Ans[time+1];
            for(int i=0; i<=time; i++) memo[i] = null;
            
            Ans ans = dp(time);
            
//            for(int i=0; i<=time; i++) System.out.println(i+" "+memo[i]);
            System.out.print(ans.total);
            if(ans.beer!=0) System.out.println(" "+ans.beer);
            else System.out.println();
        }while(sc.hasNext());

    }
    
    static Ans dp(int time){
        Ans ans = new Ans();
        if(time==0){
            return ans;
        }
        if(time<0){
            ans.beer = 99999;
            return ans;
        }
        if(time==min){
            ans.total = 1;
            return ans;
        } else if(time==max && max%min!=0){
            ans.total = 1;
            return ans;
        } else if(time<min) {
            ans.beer = time;
            return ans;
        }
        if(memo[time]!=null) return memo[time];
        
        Ans a1 = new Ans(dp(time-b1));
        Ans a2 = new Ans(dp(time-b2));
        a1.total++;
        a2.total++;
        
        if(a1.beer<a2.beer){
            ans = a1;
        } else if(a2.beer<a1.beer){
            ans = a2;
        } else {
            if(a1.total>a2.total){
                ans = a1;
            } else {
                ans = a2;
            }
        }
        
        memo[time] = new Ans(ans);
        return ans;
    }
    
    static class Ans{
        int total;
        int beer;
    
        public Ans(){
            total = beer = 0;
        }
        
        public Ans(Ans ans){
            total = ans.total;
            beer = ans.beer;
        }
        
        public String toString(){
            return total+" "+beer;
        }
    }
}
