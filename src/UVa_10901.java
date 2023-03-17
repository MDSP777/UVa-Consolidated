import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10901 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0){
			int n = sc.nextInt();
			int t = sc.nextInt();
			int nCars = sc.nextInt();
			LinkedList<Car> banks[] = new LinkedList[2];
			for(int i=0; i<2; i++) banks[i] = new LinkedList<>();
			LinkedList<Car> ship = new LinkedList<>();
			ArrayList<Car> cars = new ArrayList<>();
			for(int i=0; i<nCars; i++) {
				cars.add(new Car(i, sc.nextInt(), sc.next()));
				banks[cars.get(i).side.equals("left") ? 0 : 1].add(cars.get(i));
			}
			int side = 0;
			int curTime = 0;
			while(!banks[0].isEmpty() || !banks[1].isEmpty()) {
				while(!banks[side].isEmpty() && banks[side].peek().time<=curTime && ship.size()<n) ship.add(banks[side].poll());
				if(ship.isEmpty()) {
					if(banks[(side+1)%2].isEmpty() || (!banks[side].isEmpty() && (banks[side].peek().time<banks[(side+1)%2].peek().time))) curTime = banks[side].peek().time;
					else {
						side = (side+1)%2;
						curTime = Math.max(curTime, banks[side].peek().time)+t;
					}
					continue;
				}
				curTime+=t;
				side = (side+1)%2;
				while(!ship.isEmpty()) {
					Car c = ship.poll();
					c.arrive = curTime;
				}
			}
			for(int i=0; i<nCars; i++) System.out.println(cars.get(i).arrive);
			if(nC>0) System.out.println();
		}
	}
	
	static class Car {
		int index;
		int time;
		String side;
		int arrive;
		
		public Car(int i, int t, String s) {
			index = i;
			time = t;
			side = s;
		}
	}
}

/*

PS: Code is AC, but doesn't agree with uDebug's AC Output for brianfry713's input

In:
1
1113 1072 77
8631 left
12526 left
15884 left
19388 left
24635 left
30627 right
30627 left
31757 left
35635 right
36133 left
40444 left
43028 left
48810 right
52970 left
58960 left
68435 left
77823 right
86506 right
92642 right
102502 right
110157 right
112155 right
121380 left
129976 left
134712 left
140337 right
142189 left
144235 left
148270 right
157807 right
160444 left
166168 right
171785 left
176555 right
183147 right
187360 right
189997 left
192976 right
195552 right
202674 right
205500 right
212938 right
216050 left
219441 left
227288 left
235539 right
240714 left
244301 left
252681 left
257382 left
263605 left
264979 right
272262 right
276221 left
285386 left
293636 right
298542 right
306290 left
312539 right
318783 right
325007 right
330665 left
340213 left
345639 right
346477 left
352612 right
353809 left
362968 left
366989 right
376408 left
380605 left
386860 left
391294 left
400573 left
407871 left
413728 left
414823 left

"AC" Out:
9703
14670
18028
21532
26779
31699
32771
34915
36707
37779
42588
45172
49882
54042
61104
70579
78895
88650
94786
104646
112301
114445
122452
132120
136856
141409
143261
146379
149342
159951
161516
167240
172857
177627
185291
189504
191069
194048
197696
204818
207644
215082
217122
221585
229432
236611
241786
246445
254825
259526
265749
266821
274406
277293
287530
294708
300686
307362
313611
320927
327151
331737
342357
346711
347783
353684
354881
365112
368061
377480
382749
389004
393438
402717
410015
415872
418016

My out:
9703
14670
18028
21532
26779
33843
32771
34915
36707
37779
42588
45172
49882
54042
61104
70579
78895
88650
94786
104646
112301
114445
122452
132120
136856
141409
143261
146379
149342
159951
161516
167240
172857
177627
185291
189504
191069
194048
197696
204818
207644
215082
217122
221585
229432
236611
241786
246445
254825
259526
265749
266821
274406
277293
287530
294708
300686
307362
313611
320927
327151
331737
342357
346711
347783
353684
354881
365112
368061
377480
382749
389004
393438
402717
410015
415872
418016

Discrepancy: line 6, 31699 vs. 33843

*/