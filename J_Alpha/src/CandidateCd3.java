/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
//-1@10@-1#10@2@10#-1@10@-1
import java.io.*;
import java.util.*;

import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;

public class CandidateCd3 {

	static int zones[][] = null;
	static int weight = 0;
	static TreeSet<Integer> ts = null;
	static TreeSet<Integer> weightSet = new TreeSet<>();

	public static void main(String[] args) {
		String zoneStr = "-1@10@-1#10@2@10#-1@10@-1";
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
		convertIntoZone(0, 0);
		System.out.println(weightSet.first());
	}

	public static void convertIntoZone(int k, int l) {
		for (int i = k; i < zones.length; i++) {
			for (int j = l; j < zones[i].length; j++) {
				if (zones[i][j] != -1) {
					weight += zones[i][j];
					zones[i][j] = -1;
					displayZoneMatrix();
					boolean isCompleteZone = isCompleteZone();
					if (isCompleteZone) {
						weightSet.add(weight);
						System.out.println("Weight ::" + weight);
					} else {
						if (i == zones.length - 1) {
							if (j == zones[i].length - 1) {
								 convertIntoZone(0,0);
							} else {
								convertIntoZone(i, ++j);
							}
						} else {
							if (j == zones[i].length - 1) {
								convertIntoZone(++i, 0);
							} else {
								convertIntoZone(i, ++j);
							}
						}
					}
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
		ArrayList<TreeSet<Integer>> list=new ArrayList<>();
		for (int i = 0; i < zones.length; i++) {
			for (int j = 0; j < zones[i].length; j++) {
				boolean flag=false;
				ts=new TreeSet<>();
				int val=((i+1)*10)+(j+1);
				System.out.println(i+":::++++++++:"+j+":::"+val);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					TreeSet<Integer> treeSet = (TreeSet<Integer>) iterator.next();
					if(treeSet.contains(val)){
						flag=true;
						break;
					}
				}
				if(!flag){
					ts=new TreeSet<>();
					zoneVise(i,j);
					list.add(ts);
					System.out.println(ts);
					
				}
			}
		}	
		System.out.println("Size ::"+list.size());
		return (list.size()==1)?true:false;
	}

	public static void zoneVise(int i, int j) {
		int val=(((i + 1) * 10) + (j + 1));
		if(ts.contains(val)|| i<0 || i>=zones.length || j<0 || j>=zones[0].length){
			return;
		}
		if (zones[i][j] == -1) {
			ts.add(((i + 1) * 10) + (j + 1));
			
			zoneVise(i, ++j);
			zoneVise(i, --j);
			zoneVise(--i, j);
			zoneVise(++i, j);
		}

	}
}
