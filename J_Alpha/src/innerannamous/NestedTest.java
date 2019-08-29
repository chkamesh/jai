package innerannamous;

class Outer{
	public Outer() {
		System.out.println("Outer Constr");
	}
	public void show(){
		System.out.println("Outer Show");
	}
	class Inner{
		public Inner() {
			System.out.println("inner Const");
		}
		public void show(){
			System.out.println("Inner Show");
		}
	}
}
public class NestedTest {

	public static void main(String[] args) {
	//	new Outer().show();
		new Outer().new Inner().show();
	}

}
