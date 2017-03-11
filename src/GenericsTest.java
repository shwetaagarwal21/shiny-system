import java.util.ArrayList;
import java.util.List;


public class GenericsTest {

	public static void main(String[] args) {
		new GenericsTest().draw();

	}
	void draw() {
		List<Circle> circles = new ArrayList<Circle>();
		
		Canvas canvas = new Canvas();
		canvas.drawAll(circles);
	}
	
	abstract class Shape {
		public abstract void draw(Canvas c);
	}
	
	class Circle extends Shape {
	   private int x, y, radius;
	   public void draw(Canvas c) {
	   }
	}

	class Rectangle extends Shape {
	   private int x, y, width, height;
	   public void draw(Canvas c) {
	   }
	}

	class Canvas {
	   public void draw(Shape s) {
	       s.draw(this);
	  }
	   
	   public void drawAll(List<? extends Shape> shapes) {
		   for (Shape s: shapes) {
		       s.draw(this);
		  }
		}
	}
}
