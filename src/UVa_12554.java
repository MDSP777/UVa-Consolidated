

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_12554 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nP = sc.nextInt();
        ArrayList<String> people = new ArrayList<String>();
        for(int i=0; i<nP; i++)
            people.add(sc.next());
        singSong(people);
    }
    
    public static void singSong(ArrayList<String> people){
        String[] song = {"Happy", "birthday", "to", "you"};
        int lines=16;
        int ctr=0;
        while(lines<people.size())
            lines*=2;
        for(int i=0; i<lines; i++){
            System.out.print(people.get(ctr) + ": ");
            if(i%4==3 && Math.abs(i%16-16)%16==5)
                System.out.println("Rujia");
            else
                System.out.println(song[i%4]);
            ctr++;
            if(ctr==people.size())
                ctr=0;
        }
    }
}
