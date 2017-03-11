
public class BaseClass {
	void demo(int a){
		System.out.println("Base class: a = " + a);
	}
	
	void demo(int a, int b){
		System.out.println("Base class: a = " + a + " b = " + b);
	}
	
	double demo(double a){
		System.out.println("Base class: double a = " + a);
		return a*a;
	}
}

