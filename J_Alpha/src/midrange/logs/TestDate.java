package midrange.logs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestDate {

	public static void main(String[] args) {/*
		// TODO AutoSim-generated method stub
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

String data="2018 Jul 15 08:28:38";
String data1=(new Date().getYear()+1900)+" Jul 15 08:28:38 nasmsgdev20 ";
String dateStr="Jul 15 08:28:38 nasmsgdev20".substring(0, 15);
	dateStr=(new Date().getYear()+1900)+" "+dateStr;
	System.out.println(dateStr);
System.out.println(data1);
try {
	System.out.println(dateFormat.parse(data));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	*/
	HashMap<String, String>	 hm=new HashMap<>();
	hm.put(new String("aaa"), "abcd");
	hm.put("aaa", "abc");
	System.out.println(hm.size()+"::"+hm.get("aaa"));
	}

}
