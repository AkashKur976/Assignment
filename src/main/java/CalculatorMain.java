
class Calc{
	public int add(int a,int b) {
		return a+b;
	}
}
public class CalculatorMain {
	public static void main(String args[]) {
		Calc c1 = new Calc();
		int a = c1.add(3,4);
		System.out.print(a);

	}
}
