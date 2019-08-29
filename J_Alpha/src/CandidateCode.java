
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CandidateCode {

	static char squareMatrix[][] = null;
	static int n = 0;
	static String searchStr = "";
	static String squareStr = null;
	static int searchStrLen = 0;
	static int count = 0;

	

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			n = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			throw new Exception("input Not properly");
		}
		squareMatrix = new char[n][n];

		for (int i = 0; i < n; i++) {
			squareStr = scanner.next();
			Pattern p = Pattern.compile("^[A-Z@#]*$");
			Matcher m = p.matcher(squareStr);
			boolean b = m.matches();
			if (!b)
				throw new Exception("String not properly formed");
			String strArr[] = squareStr.split("#");
			if(strArr.length!=n)
				throw new Exception("String not properly formed");
			for (int j = 0; j < strArr.length; j++) {
				String string = strArr[j];
				if (string.length() == 1)
					squareMatrix[i][j] = string.charAt(0);
			}

		}
		try {
			searchStr = scanner.next().trim();
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			throw new Exception("input Not properly");
		}
		searchStrLen = searchStr.length();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String extStr = "";
				// searchString(i, j, 0, extStr, 0, 0);
				int dirX = 0;
				int dirY = 0;
				if (squareMatrix[i][j] == searchStr.charAt(0)) {
					if(searchStrLen==1){
						count++;
						continue;
					}
					// System.out.println("squareMatrix");
					extStr = "";
					dirX = 0;
					dirY = 1;
					searchString(i, j, 0, extStr, dirX, dirY);

					dirX = 1;
					dirY = 1;
					searchString(i, j, 0, extStr, dirX, dirY);

					dirX = 1;
					dirY = 0;
					searchString(i, j, 0, extStr, dirX, dirY);

//					dirX = -1;
//					dirY = 0;
//					searchString(i, j, 0, extStr, dirX, dirY);

					dirX = -1;
					dirY = 1;
					searchString(i, j, 0, extStr, dirX, dirY);

					dirX = 1;
					dirY = -1;
					searchString(i, j, 0, extStr, dirX, dirY);

//					dirX = 0;
//					dirY = -1;
//					searchString(i, j, 0, extStr, dirX, dirY);

					dirX = -1;
					dirY = -1;
					searchString(i, j, 0, extStr, dirX, dirY);
				}
			}
		}
		System.out.print(count);
	}

	private static void searchString(int i, int j, int len, String extStr, int dirX, int dirY) {
		// System.out.println("Search Str ::" + i + "::" + j + " len:::" + len +
		// " ext str :" + extStr + " dirx::" + dirX
		// + " dir Y::" + dirY + " ::");

		if ((i < 0 || i >= n) || (j < 0 || j >= n)) {
			// System.out.println("return :" + i + "n:" + j + " n: " + n);
			return;
		}
		if (squareMatrix[i][j] == searchStr.charAt(len)) {
			// System.out.println("squareMatrix[" + i + "][" + j + "] ::" +
			// squareMatrix[i][j]);
			extStr += squareMatrix[i][j];
			len++;
			if (searchStrLen == len && extStr.equals(searchStr)) {
				// System.out.println(":::" + extStr);
				count++;
				return;
			}
		} else
			return;
		{
			searchString(i + dirX, j + dirY, len, extStr, dirX, dirY);
		}
	}
}
