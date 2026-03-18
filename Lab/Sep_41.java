package lab;


public class Sep_41 {
	
	void f() {
		System.out.println("in f()");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//f();//inside a static method can not use non-static function
		// proper way to call 
		Sep_41 lab=new Sep_41();
		lab.f();
		
		A a= new A();
		B b=new B();
		D d=new D();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(d);
		
		a.k=31;
		a.m=32;
		//a.n=33; protected variable can be accessed only be the derived class
		//a.p=34;  it is invisible because it is declared private
		
		b.k=41;
		b.m=42;
		b.n=43;
		//b.p=44; 
		
		d.k=51;
		d.m=52;
		d.n=53;
		//c.p=54;
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(d);
		
		
		
		//Second Part of Lesson-static
		E e1=new E();
		System.out.println(e1);
		
		E e2=new E();
		System.out.println(e2);
		e1.n=11;
		e1.m=14;
		//E.n=12;
		E.m=13;//proper way to access a static variable
			
			

	}

}


//Comparing accessibility
class A{
	public int k=1;
	int m=2;//package accessibility;
	protected int n=3;
	private int p=4;// for private it can not be accessed outside of the A class 
	public A() {
		
	}
	public String toString() {
		return "A: k= "+k+" m= "+m+" n= "+n+" p= "+p;
	}
	
}


class B extends A{
	public int k=11;
	int m=12;//package accessibility;
	protected int n=13;
	private int p=14;// B has its own p in class B so there is not a error here
	public B() {
		
	}
	public String toString() {
		//A.p=66;
		//super.p=66;
		return "B: k= "+k+" m= "+m+" n= "+n+" p= "+p;
	}
	
}



class D extends A{
	public D() {
		k=21;
		m=22;
		n=23;
		//p=24;
	}
	public String toString() {
		//return "C: k= "+k+" m= "+m+" n= "+n+" p= "+p;
		return "D: k= "+k+" m= "+m+" n= "+n;
	}
}



class E{
	int n=0;
	static int m=0;// makes it so that it uses the same object/integer m when creating new objects
	// so when you increment m=0-class E, m=1-object e, m=2 object e1
	public E() {
		n++;
		m++;
	}
	public String toString() {
		return "n = "+n+" m = "+m;
		
	}
	
}