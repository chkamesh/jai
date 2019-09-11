package innerannamous;

class Outer1{
	public Outer1() {
		System.out.println("Outer Constr");
		
				
	}
	public void show(){
		System.out.println("Outer Show");
		class Inner1{
			public void show(){
				System.out.println("Inner1 Show");
			}
		}
		Inner1 i=new Inner1();
		i.show();
	}
	
}
public class MethodLocalTest {

	public static void main(String[] args) {
	//	new Outer().show();
		new Outer1().show();
	}

}
