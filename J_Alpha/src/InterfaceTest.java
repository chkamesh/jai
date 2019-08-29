interface Parent{
	default public void getMsg(){
		System.out.println("getMsg");
		getSMsg();
		getMsgTwo();
	}
	static void getSMsg(){
		System.out.println("SMsg");
	}
	default public void getMsgTwo(){
		System.out.println("getMsgTwo()");
	}
}
class CPArent{
	static void getCSMsg(){
		System.out.println("getCSMsg");
	}
}
public class InterfaceTest extends CPArent implements Parent{

	public static void main(String[] args) {
		new InterfaceTest().getMsg();
	}
	 public void getMsg(){
		 //Parent.super.getMsg();;
		 getCSMsg();
		 System.out.println("SsubGetMsg");
	}
//	static void getSMsg(){
//		Parent.getSMsg();
//		System.out.println("SsubMsg");
//	}

}
