import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTestCase {
	public static void main(String[] args) {
		String s="-1@10@-1#10@2@10#-1@10@-1";

		Pattern p = Pattern.compile("^[0-9@#-]*$");// . represents single character
		Matcher m = p.matcher(s);
		boolean b = m.matches();
		System.out.println(b);
	    Pattern st = Pattern.compile("-1");
		Matcher stm = st.matcher("-1@0@-1#0");
		boolean stb = stm.matches();
		System.out.println(stb);
		if(s.contains("##") ||s.contains("#@")|| s.contains("@#") ||s.contains("@@") ||s.contains("--") || s.startsWith("#")|| s.startsWith("@")|| s.endsWith("#")|| s.endsWith("@"))
			System.out.println("ss");
		
		LinkedHashSet<Point> hashSet=new  LinkedHashSet<>();
	}
}
