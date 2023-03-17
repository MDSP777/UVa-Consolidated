import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class UVa_10138 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		br.readLine();
		while(tc-->0){
			double[] costs = new double[24];
			String[] split = br.readLine().split(" ");
			for(int i=0; i<24; i++) costs[i] = Double.parseDouble(split[i])/100.0;
			ArrayList<Record> records = new ArrayList<>();
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				split = s.split(" ");
				String[] timeData = split[1].split(":");
				records.add(new Record(split[0], Integer.parseInt(timeData[0]), Integer.parseInt(timeData[1]), Integer.parseInt(timeData[2]), Integer.parseInt(timeData[3]), split[2].equals("enter"), Integer.parseInt(split[3])));
			}
			Collections.sort(records);
			HashMap<String, Double> fees = new HashMap<>();
			HashMap<String, Record> tracker = new HashMap<>();
			TreeSet<String> plates = new TreeSet<>();
			for(Record r: records){
				if(!r.enter && tracker.containsKey(r.plate)){
					Record enter = tracker.get(r.plate);
					if(!fees.containsKey(r.plate)) fees.put(r.plate, 2.0);
					double cost = 1.0+Math.abs(r.km-enter.km)*costs[enter.hour];
					fees.put(r.plate, fees.get(r.plate)+cost);
					tracker.remove(r.plate);
					plates.add(r.plate);
				}
				if(r.enter) tracker.put(r.plate, r);
			}
			for(String s : plates) System.out.printf("%s $%.2f\n", s, fees.get(s));
			if(tc>0) System.out.println();
		}
	}
	
	static class Record implements Comparable<Record> {
		String plate;
		int month;
		int day;
		int hour;
		int min;
		boolean enter;
		int km;
		
		public Record(String p, int mo, int d, int h, int mi, boolean e, int k){
			plate = p;
			month = mo;
			day = d;
			hour = h;
			min = mi;
			enter = e;
			km = k;
		}

		public int compareTo(Record o) {
			if(month==o.month){
				if(day==o.day){
					if(hour==o.hour) return min-o.min;
					return hour-o.hour;
				}
				return day-o.day;
			}
			return month-o.month;
		}
	}
}
