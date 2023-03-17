

import java.util.Scanner;

public class UVa_12015 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        url[] u;
        int hRel;
        int c = sc.nextInt();
        String dump = sc.nextLine();
        for(int i=1; i<=c; i++){
            hRel = -999;
            u = new url[10];
            for(int j=0; j<10; j++){
                u[j] = new url();
                u[j].name = sc.next();
                u[j].relevance = sc.nextInt();
                dump = sc.nextLine();
                if(u[j].relevance>hRel)
                    hRel = u[j].relevance;
            }
            System.out.println("Case #" + i + ":");
            for(int j=0; j<10; j++)
                if(u[j].relevance==hRel)
                    System.out.println(u[j].name);
        }
    }
    
    public static class url{
        public int relevance;
        public String name;
    }
}