

import java.util.Scanner;

public class UVa_10350 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int in = sc.nextInt();
            if(in==0) break;
            boolean[] inputs = new boolean[11];
            while(true){
                sc.nextLine();
                String response = sc.nextLine();
                if(response.equals("too high")){
                    for(int i=in; i<=10; i++)
                        inputs[i] = true;
                }else if(response.equals("too low")){
                    for(int i=in; i>=1; i--)
                        inputs[i] = true;
                }else{
                    if(inputs[in]) System.out.println("Stan is dishonest");
                    else System.out.println("Stan may be honest");
                    break;
                }
                in = sc.nextInt();
            }
        }

    }
}
