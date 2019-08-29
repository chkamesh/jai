import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
	int id;
	String name;
	int hash;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" "+this.name+"  "+this.hash;
	}

	public SetTest(int id, String name, int hash) {
		super();
		this.id = id;
		this.name = name;
		this.hash = hash;
	}

	public static void main(String[] args) {
		ArrayList<SetTest> arrayList=new ArrayList<>();
		SetTest setTest1 = new SetTest(1, "AAA", 11);
		SetTest setTest2 = new SetTest(2, "BBB", 12);
		SetTest setTest3 = new SetTest(1, "AAA", 11);
		arrayList.add(setTest1);
		arrayList.add(setTest2);
		arrayList.add(setTest3);
		ArrayList<SetTest> arrayList2=(ArrayList<SetTest>)arrayList.clone();
		
		Set<SetTest> set=new HashSet<>(arrayList2);
//		set.add(setTest1);
//		set.add(setTest2);
//		set.add(setTest3);
		setTest1.name="sss";
		System.out.println(arrayList2.get(0).name="5555");
		System.out.println(arrayList.get(0).hashCode());
		System.out.println(set.toString());
		System.out.println(arrayList.toString());
		System.out.println(arrayList2.toString());
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals:"+this.toString());
		SetTest geek = (SetTest) obj; 
		System.out.println("equals: This :"+this.toString()+"Arg::"+geek.toString());
		return (geek.name == this.name && geek.id == this.id);
	}

//	@Override
//	public int hashCode() {
//		System.out.println("hashcode:"+this.toString());
//		return hash;
//	}

}
