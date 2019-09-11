
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
//-1@10@-1#10@2@10#-1@10@-1
import java.io.*;
import java.util.*;

import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;

public class CandidateCd {

	static int zones[][] = null;
	static int weight = 0;
	static TreeSet<Integer> ts = null;
	static TreeSet<Integer> weightSet = new TreeSet<>();

	public static void main(String[] args) {
		String zoneStr = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter String:");
		zoneStr = scanner.next();
		String zoneRow[] = zoneStr.split("#");
		zones = new int[zoneRow.length][];
		for (int i = 0; i < zoneRow.length; i++) {
			String zoneCell[] = zoneRow[i].split("@");
			zones[i] = new int[zoneCell.length];
			for (int j = 0; j < zones[i].length; j++) {
				zones[i][j] = Integer.parseInt(zoneCell[j]);
			}

		}
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				System.out.print(zones[i][j] + " ");
			}
			System.out.println("\n ");
		}
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				TreeSet<Integer> visitedNode=new TreeSet<>();
				convertIntoZone(i, j,visitedNode);
			}
		}
		System.out.println(weightSet.first());
	}

	public static void convertIntoZone(int i, int j, TreeSet<Integer> visitedNode) {
		int val = ((i + 1) * 10) + (j + 1);
		if (visitedNode.contains(val)||i < 0 || i >= zones.length || j < 0 || j >= zones[0].length) {
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
				visitedNode.add(val);
				displayZoneMatrix();
				boolean isCompleteZone = isCompleteZone();
				if (isCompleteZone) {
					weightSet.add(weight);
					System.out.println("Weight ::" + weight);
				} else {

					convertIntoZone(i, j + 1,visitedNode);
					convertIntoZone(i, j - 1,visitedNode);
					convertIntoZone(i - 1, j,visitedNode);
					convertIntoZone(i + 1, j,visitedNode);

					convertIntoZone(i + 1, j + 1,visitedNode);
					convertIntoZone(i + 1, j - 1,visitedNode);
					convertIntoZone(i - 1, j - 1,visitedNode);
					convertIntoZone(i - 1, j + 1,visitedNode);
					// if (i == zones.length - 1) {
					// if (j == zones[i].length - 1) {
					// convertIntoZone(i - 1, j);
					// convertIntoZone(i, j + 1);
					// } else {
					// convertIntoZone(i - 1, j);
					// convertIntoZone(i, j - 1);
					// convertIntoZone(i, j + 1);
					// }
					// } else {
					// if (j == zones[i].length - 1) {
					// convertIntoZone(i - 1, j);
					// convertIntoZone(i + 1, j);
					// convertIntoZone(i, j - 1);
					// } else {
					// convertIntoZone(i - 1, j);
					// convertIntoZone(i, j - 1);
					// convertIntoZone(i, j + 1);
					// convertIntoZone(i + 1, j);
					// }
					// }
				}
			}
		}
	}

	public static void displayZoneMatrix() {
		System.out.println("================= ");
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				System.out.print(zones[i][j] + " ");
			}
			System.out.println("\n ");
		}
		System.out.println("================= ");
	}

	public static boolean isCompleteZone() {
		boolean isComplete = false;
		ArrayList<TreeSet<Integer>> list = new ArrayList<>();
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				boolean flag = false;
				ts = new TreeSet<>();
				int val = ((i + 1) * 10) + (j + 1);
				// System.out.println(i + ":::+++++$$$$$$$$$+++:" + j + ":::" +
				// val);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					TreeSet<Integer> treeSet = (TreeSet<Integer>) iterator.next();
					if (treeSet.contains(val)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					ts = new TreeSet<>();
					zoneVise(i, j);
					if (ts.size() != 0) {
						list.add(ts);
						System.out.println(ts);
					}

				}
			}
		}
		System.out.println("Size ::" + list.size());
		return (list.size() == 1) ? true : false;
	}

	public static void zoneVise(int i, int j) {
		// System.out.println(i + ":::++++++++:" + j + ":::");

		int val = (((i + 1) * 10) + (j + 1));
		if (ts.contains(val) || i < 0 || i >= zones.length || j < 0 || j >= zones[0].length) {
			return;
		}
		// System.out.println(i + ":::++++++++:" + j + "::::::::::"
		// +zones[i][j]);
		if (zones[i][j] == -1) {
			ts.add(((i + 1) * 10) + (j + 1));

			zoneVise(i, j + 1);
			zoneVise(i, j - 1);
			zoneVise(i - 1, j);
			zoneVise(i + 1, j);

			zoneVise(i + 1, j + 1);
			zoneVise(i + 1, j - 1);
			zoneVise(i - 1, j - 1);
			zoneVise(i - 1, j + 1);
		}

	}
}
