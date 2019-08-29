package innerannamous;

import java.util.HashMap;

class Outer2{
	public Outer2() {
		System.out.println("Outer Constr");
		
				
	}
	public void show(){
		System.out.println("Outer Show");
		
	}
	static class Inner1{
		public Inner1() {
			System.out.println("inner Constr");
			
		}
		public void show(){
			System.out.println("Inner1 Show");
		}
	}
	
}
interface In{
	public void msg();
}
public class StaticInnerTest {

	public static void main(String[] args) {
//		HashMap hashMap=new  
//	//	new Outer().show();
		In in=new In() {
			{
				System.out.println("star");
			}
			@Override
			public void msg() {
			System.out.println("msg");	
			System.out.println(this.getClass());
			}
			
		};
		In in3=new In() {
			{
				System.out.println("star");
			}
			@Override
			public void msg() {
			System.out.println("msg1");	
			System.out.println(this.getClass());
			}
			
		};
		try {
			System.out.println(in.getClass());
			System.out.println(in3.getClass());
			try {
				In in2=(In) Class.forName("innerannamous.StaticInnerTest$1").newInstance();
				in2.msg();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
//in.msg();
		//Outer2.Inner1 i= new Outer2.Inner1();
		//i.show();
		
	}

}
