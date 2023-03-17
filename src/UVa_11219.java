

import java.util.Scanner;

public class UVa_11219 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        for(int i=1; i<=t; i++){
            sc.nextLine();
            String[] a = sc.nextLine().split("/");
            String[] b = sc.nextLine().split("/");
            int[] now = new int[3];
            int[] birth = new int[3];
            for(int j=0; j<3; j++){
                now[j] = Integer.parseInt(a[j]);
                birth[j] = Integer.parseInt(b[j]);
            }
            int age;
            if(birth[2]>now[2] || (birth[2]==now[2] && birth[1]>now[1]) || (birth[2]==now[2] && birth[1]==now[1] && birth[0]>now[0])){
                System.out.println("Case #"+i+": Invalid birth date");
            }
            else if(now[2]-birth[2]>131 || (now[2]-birth[2]==131 && now[1]>birth[1]) || (now[2]-birth[2]==131 && now[1]==birth[1] && now[0]>=birth[0]))
                    System.out.println("Case #"+i+": Check birth date");
            else{
                age = now[2]-birth[2];
                if(now[1]<birth[1] || (now[1]==birth[1] && now[0]<birth[0])) age--;
                System.out.println("Case #"+i+": "+age);
            }
        }
    }
}
