import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UVa_11947 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
			Date d = sdf.parse(sc.next());
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d);
			gc.add(GregorianCalendar.DAY_OF_WEEK, 280);
			int month = gc.get(GregorianCalendar.MONTH)+1;
			int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
			int year = gc.get(GregorianCalendar.YEAR);
			System.out.println(i+" "+(month<10 ? "0" : "")+month+"/"+(day<10 ? "0" : "")+day+"/"+year+" "+getSign(gc).toLowerCase());
		}
	}
	
	static String getSign(GregorianCalendar gc) {
		if(gc.get(GregorianCalendar.MONTH)==0)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=21 ? "Aquarius" : "Capricorn";
		if(gc.get(GregorianCalendar.MONTH)==1)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=20 ? "Pisces" : "Aquarius";
		if(gc.get(GregorianCalendar.MONTH)==2)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=21 ? "Aries" : "Pisces";
		if(gc.get(GregorianCalendar.MONTH)==3)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=21 ? "Taurus" : "Aries";
		if(gc.get(GregorianCalendar.MONTH)==4)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=22 ? "Gemini" : "Taurus";
		if(gc.get(GregorianCalendar.MONTH)==5)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=22 ? "Cancer" : "Gemini";
		if(gc.get(GregorianCalendar.MONTH)==6)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=23 ? "Leo" : "Cancer";
		if(gc.get(GregorianCalendar.MONTH)==7)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=22 ? "Virgo" : "Leo";
		if(gc.get(GregorianCalendar.MONTH)==8)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=24 ? "Libra" : "Virgo";
		if(gc.get(GregorianCalendar.MONTH)==9)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=24 ? "Scorpio" : "Libra";
		if(gc.get(GregorianCalendar.MONTH)==10)
			return gc.get(GregorianCalendar.DAY_OF_MONTH)>=23 ? "Sagittarius" : "Scorpio";
		return gc.get(GregorianCalendar.DAY_OF_MONTH)>=23 ? "Capricorn" : "Sagittarius";	
	}
}
