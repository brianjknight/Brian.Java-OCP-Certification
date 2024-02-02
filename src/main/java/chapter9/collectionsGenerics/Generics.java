package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class Generics<T, U, HAMBURGER, _H0td$9> { // follows naming convention of variables
	private T name;
	private U age;
	
	public Generics() {};
	
	public Generics (T t, U u) {
		this.name = t;
		this.age = u;
	}
	
	public T getName() {return name;}
	public U getAge() {return age;}
	
	public void doNothing(List<Object> in) {}
//	public void doNothing(List<String> in) {} // parameterized types are not considered different for overloading/overriding
	public void doNothing(List<String> in, String s) {}
	
	public List<CharSequence> getter() {return new ArrayList<>();}
	
	public static void main(String[] args) {
		Generics omitDiamond = new Generics<String, Integer, Object, Object>("Brian", 39);  // DECLARATION OMITS <> AND PARAM TYPES java infers both as Object
//		System.out.println(g.getName() + g.getAge()); // does not compile '+' operator undefined for Object
		System.out.println(omitDiamond.getName()); // works because Object is the reference type but implementation is String toString() method 
		System.out.println(omitDiamond.getName().toString() + omitDiamond.getAge().toString()); 
		
		Generics<String, Integer, Object, Object> includeParamTypes = new Generics<>("Brian", 39);
		// TYPE ERASURE after Java compiles all generics are Objects, however the compilier adds relevant casting behind the scenes for declared type
		// now  getName() is cast as a String and getAge() cast as Integer, so operator works with operator using Integer.toString()
		System.out.println(includeParamTypes.getName() + includeParamTypes.getAge()); 
		
		List list = new ArrayList(); // Java infers Object for parameterized type when omitted
		
		list.add("cat");
		list.add(9);
		list.add(false);
		
		list.forEach(o -> System.out.println(o + " | " + o.getClass()));
		
//		System.out.println(list.get(0) + list.get(1)); // does not compile since '+' operator cannot be used for Object
		System.out.println(" " + list.get(0) + list.get(1)); // java infers string from " " and uses Object toString()
		
//		List<> badList = new ArrayList<Integer>(); // diamond operator requires a type for declaration
		
		List intList = new ArrayList<Integer>(); // Java still infers Object type when declaration <> is omitted
		intList.add("1");
		intList.add(2);
		intList.add(3.0);
		System.out.println(intList);
		
		
//		List<Object> objList = new ArrayList<Integer>(); // not allowed to mix types even if a sub type
		
		
	}
}


