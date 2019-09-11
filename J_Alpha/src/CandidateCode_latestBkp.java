
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
//-1@10@-1#10@2@10#-1@10@-1
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CandidateCode_latestBkp {

	static int zones[][] = null;
	static long weight = 0;
	static HashSet<Point> ts = null;
	static TreeSet<Long> weightSet = new TreeSet<>();
	static boolean hasCommZone = false;

	public static void main(String[] args) throws Exception {
		String zoneStr = "";
		Scanner scanner = new Scanner(System.in);
		zoneStr = scanner.next();
		Pattern p = Pattern.compile("^[0-9@#-]*$");
		Matcher m = p.matcher(zoneStr);
		boolean b = m.matches();
		if (!b)
			throw new Exception("Zone String not properly formed");
		if (zoneStr.contains("##") || zoneStr.contains("#@") || zoneStr.contains("@#") || zoneStr.contains("@@")
				|| zoneStr.contains("--") || zoneStr.startsWith("#") || zoneStr.startsWith("@") || zoneStr.endsWith("#")
				|| zoneStr.endsWith("@"))
			throw new Exception("Zone String not properly");
		String zoneRow[] = zoneStr.split("#");
		if (zoneRow.length <= 0) {
			throw new Exception("Rows not greater than or equal to 1");
		}
		if (zoneRow.length > 1000) {
			throw new Exception("Rows greater than 1000");
		}
		zones = new int[zoneRow.length][];
		for (int i = 0; i < zoneRow.length; i++) {
			String zoneCell[] = zoneRow[i].split("@");
			zones[i] = new int[zoneCell.length];
			for (int j = 0; j < zones[i].length; j++) {
				if ((i > 0 && zones[0].length != zones[i].length)) {
					throw new Exception("rows and colums are not properly");
				}
				if (zones[i].length > 1000) {
					throw new Exception("Columns more than 1000");
				}
				if (zones[i].length <= 0) {
					throw new Exception("Columns not greater than equal to 1");
				}
				zones[i][j] = Integer.parseInt(zoneCell[j]);
			}
		}
		boolean isCompleteZone = isCompleteZone();
		if (isCompleteZone) {
			System.out.println("0");
			return;
		}

		if (hasCommZone) {
			for (int i = 0; i < zones.length; i++) {
				for (int j = 0; j < zones[i].length; j++) {
					HashSet<Point> visitedNode = new HashSet<>();
					convertIntoZone(i, j, visitedNode);
				}
			}
		} else {
			System.out.println("0");
			return;
		}
		if (weightSet.size() == 0)
			System.out.println("0");
		else
			System.out.println(weightSet.first());
	}

	public static void convertIntoZone(int i, int j, HashSet<Point> visitedNode) {
		Point point = new Point(i, j);
		if (visitedNode.contains(point) || i < 0 || i >= zones.length || j < 0 || j >= zones[i].length) {
			return;
		}
		if (zones[i][j] != -1) {

			int initialValue = zones[i][j];
			for (int indx = 1; indx < 3; indx++) {
				if (indx == 1) {
					weight += zones[i][j];
					zones[i][j] = -1;

				} else {

					weight = weight - initialValue;
					zones[i][j] = initialValue;
				}
				visitedNode.add(point);
				/*if(indx==1){
					
				}*/
				displayZoneMatrix();
				//boolean isCompleteZone = isCompleteZone();
				if (indx==1 || isCompleteZone()) {
					weightSet.add(weight);
					//displayZoneMatrix();
					
					System.out.println("Weight ::" + weight);
				} else {

					convertIntoZone(i, j + 1, visitedNode);
					convertIntoZone(i, j - 1, visitedNode);
					convertIntoZone(i - 1, j, visitedNode);
					convertIntoZone(i + 1, j, visitedNode);

					convertIntoZone(i + 1, j + 1, visitedNode);
					convertIntoZone(i + 1, j - 1, visitedNode);
					convertIntoZone(i - 1, j - 1, visitedNode);
					convertIntoZone(i - 1, j + 1, visitedNode);
				}
			}
		}
		//else
//		{
//			visitedNode.add(point);
//			
//		}
	}

	private static void displayZoneMatrix() {
		System.out.println("================= ");
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				System.out.print(zones[i][j] + " ");
			}
			System.out.println("\n ");
		}
		System.out.println("================= ");
	}

	private static boolean isCompleteZone() {

		ArrayList<HashSet<Point>> list = new ArrayList<>();
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				boolean flag = false;
				ts = new HashSet<>();
				Point point = new Point(i, j);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HashSet<Point> hashSet = (HashSet<Point>) iterator.next();
					if (hashSet.contains(point)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					ts = new HashSet<>();
					zoneWise(i, j);
					if (ts.size() > 0) {
						list.add(ts);
						hasCommZone = true;
					}
				}
			}
		}
		if (list.size() == 1) {
			return (list.size() == 1) ? true : false;
		} else
			return false;
	}

	private static void zoneWise(int i, int j) {

		Point point = new Point(i, j);
		// System.out.println(ts);
		// System.out.println(point);
		if (ts.contains(point) || i < 0 || i >= zones.length || j < 0 || j >= zones[i].length) {
			return;
		}
		if (zones[i][j] == -1) {
			ts.add(new Point(i, j));

			zoneWise(i, j + 1);
			zoneWise(i, j - 1);
			zoneWise(i - 1, j);
			zoneWise(i + 1, j);

			zoneWise(i + 1, j + 1);
			zoneWise(i + 1, j - 1);
			zoneWise(i - 1, j - 1);
			zoneWise(i - 1, j + 1);
		}

	}
}

/*class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		// System.out.println(x+"::::"+y);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point node = (Point) obj;
		return x == node.getX() && y == node.getY();
	}

	@Override
	public int hashCode() {
		return 31 * x + y;
	}

	@Override
	public String toString() {
		return "X:=>" + x + " Y:=>" + y;
	}

}
*/