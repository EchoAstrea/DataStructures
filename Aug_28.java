package lab;

public class Aug_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Rectangle r1=new Rectangle(), r2=new Rectangle(10,20), r3=new Rectangle(10,20), r4=r2;
		System.out.println(r1.toString());
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r2==r3);
		System.out.println(r2==r4);
		System.out.println(r2.equals(r3));
		System.out.println(r2.equals(r4));
		
		
		
		Square s1=new Square(17), s2=new Square();
		System.out.println(s1+ " its area = "+s1.area());
		
		
		*/
		//I i=new I();// cannot be done for interfaces
		

	}
}
	
	
	class Rectangle extends Object{
		protected double width, height; //protected can be used when you want to give to the square/inherited 
		//also we know that the Square is the end of the inherited
		public Rectangle() {
			
		}
		public Rectangle(double w, double h) {
			width=w;
			height=h;
		}
		public void setWidth(double w) {
			width=w;
		}
		//@Override
		public String toString() {
			return width+"/"+height;
		}
		/*
		public boolean equals(Rectangle r) {
			return width==r.width && height==r.height;
		}
		*/
		//@Override
		public boolean equals(Object r) {
			return width==((Rectangle)r).width && height==((Rectangle)r).height;
			// in project equals method must be defined like this
		}
		public double area() {
			return width*height;
		}
	}
	class Square extends Rectangle{
		public Square() {
			
		}
		public Square(double s) {
			width=height=s;
	}
		public String toString() {
			return "side = "+width;
		}
		

}

	interface I{//what is an interface and what is its use
		  int n=10;//integer n=10; package visibility can be found in the same file
		void f();
		default void g() {//to have something be included in the interface you must use default
			// it somewhat undermines the interface 
			
		}
		//void f() {
			//n=20;
			//System.out.println(n);
		//}
	}

	class C implements I{//class c gets all data from class I
		public void f() {// the word 'public' must be included but not nessecary in I
			//n=20;// n is the constant final int can not be modified
			System.out.println(n);
	}
		
	}