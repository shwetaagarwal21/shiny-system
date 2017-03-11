
public class TestMethod {

	public static void main(String[] args) {
		BaseClass baseClass = new BaseClass();
		
		BaseClass derivedClass = new DerivedClass();
		baseClass.demo(5, 10);
		
		derivedClass.demo(6, 12);
		
		
		DerivedClass der = new DerivedClass();
		
		der.demo(1,2,3);

	}

}
