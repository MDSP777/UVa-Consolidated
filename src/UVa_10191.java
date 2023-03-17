

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10191 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int day = 1;
        do{
            int nScheds = sc.nextInt();
            sc.nextLine();
            ArrayList<Schedule> scheds = new ArrayList();
            scheds.add(new Schedule(10, 10, 0, 0));
            for(int i=0; i<nScheds; i++){
                String[] schedDetails = sc.nextLine().split(" ");
                String[] start = schedDetails[0].split(":");
                String[] end = schedDetails[1].split(":");
                scheds.add(new Schedule(Integer.parseInt(start[0]), 
                        Integer.parseInt(end[0]), 
                        Integer.parseInt(start[1]), 
                        Integer.parseInt(end[1])));
            }
            Collections.sort(scheds);
            scheds.add(new Schedule(18, 18, 0, 1));
            System.out.println("Day #"+day+++": "+calcNap(scheds));
        }while(sc.hasNext());

    }

    private static String calcNap(ArrayList<Schedule> scheds) {
        int longestNap = 0;
        String napStartTime = "";
        int nScheds = scheds.size();
        for(int i=1; i<nScheds; i++){
            int newNap = findDist(scheds.get(i-1), scheds.get(i));
            if(newNap>longestNap){
                longestNap = newNap;
                napStartTime = scheds.get(i-1).getEnd();
            }
        }
        String ans = "the longest nap starts at "+napStartTime+" and will last for "+convertToHM(longestNap);
        return ans;
    }

    private static int findDist(Schedule s1, Schedule s2) {
        int nHours = s2.startH - s1.endH;
        int nMins = s2.startM - s1.endM;
        return 60*nHours + nMins;
    }

    private static String convertToHM(int longestNap) {
        int nHours = longestNap / 60;
        int nMins = longestNap % 60;
        if(nHours==0) return nMins+" minutes.";
        else return nHours+" hours and "+nMins+" minutes.";
    }
    
    static class Schedule implements Comparable<Schedule>{
        int startH;
        int endH;
        int startM;
        int endM;
        
        public Schedule(int a, int b, int c, int d){
            startH = a;
            endH = b;
            startM = c;
            endM = d;
        }

        @Override
        public int compareTo(Schedule o) {
            if(this.startH < o.startH) return -1;
            else if(this.startH > o.startH) return 1;
            else {
                if(this.startM < o.startM) return -1;
                else if(this.startM > o.startM) return 1;
                else return 0;
            }
        }

        private String getEnd() {
            String s = endH+":";
            s = (endM<10) ? s+"0"+endM : s+endM;
            return s;
        }
        
        
    }
}
