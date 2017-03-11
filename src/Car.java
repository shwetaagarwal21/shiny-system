import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Car implements Comparable {
	
	String carName;
	int price;
	
	Car(){
		super();
	}
	
	Car(String carName, int price){
		this.carName = carName;
		this.price = price;
	}
		
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Object o) {
		Car car = (Car)o;
		if(this.price > car.price)
			return 1;
		else if(this.price < car.price)
			return -1;
		else return 0;
	}
	
	public static void main(String args[]){
		Car maruti = new Car("Maruti", 20);
		Car honda = new Car("Honda", 100);
		Car suv = new Car("Suv", 70);
		Car wagon = new Car("Wagon", 40);
		List<Car> carList = new ArrayList<>();
		carList.add(maruti);
		carList.add(honda);
		carList.add(suv);
		carList.add(wagon);
		Collections.sort(carList);
		System.out.println(((Car)(Collections.max(carList))).carName);
		
	}

}
