package lab;
import java.util.ArrayList;
public class Sep_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		Integer m= new Integer(6);
		//needed to use for earlier ver of Java
		m =n;
		//boxing
		m =new Integer(6); 
		
		//Translated to the same thing just depends on 1.later or 2.early ver
		n=m;
		//unboxing
		n=m.intValue();
		
		// diff between int and Integer: 
		//Integer is a class/object-only holding an address of the object =6
		// the number six belongs in the object but not inside the Integer data type
		// int has the =5 inside 
		// wrapper type
		F<Integer, String> c1=new F<Integer, String>();
		//same thing as above just shorten syntax
		F<Integer, String> c2=new F<>();
		
		
		//arrays are counted by 0 
		// last thing you can do is 4 
		int []a= new int[5];
		a[5]=11;
		//Wrapper type must be used when doing array list
		// can not use int or regular data types
		ArrayList<Integer> aList=new ArrayList<>();
		
		//aList.find[0]=3; not proper way for array list
		aList.add(6);//adding number 6 not specifying where it is going
		
		System.out.println(aList.get(0));
		
		
		
		
		
		
		
		
		

	}

}

//generic class
class F<T1, T2>{//angle bracket notation
	T1 n;
	T2 m;
	//can generate single variables but can not create an object 
	//T1 a= new T1();
	//T1 b= new T1[10]; 
	
	T1 f(T2 t2, int k) {
		T1 t1;
		t1=null;
		System.out.println(t1);
		return t1;
		}
}

