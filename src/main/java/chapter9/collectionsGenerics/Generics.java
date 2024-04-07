package chapter9.collectionsGenerics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generics<T, U, hamburger, _H0tdo9s> { // follows naming convention of variables
	private T name;
	private U age;
	private hamburger bigMac;
	
	public Generics() {};
	
	public Generics (T t, U u) {
		this.name = t;
		this.age = u;
	}
	
	public T getName() {return name;}
	public U getAge() {return age;}
	
	public <T> T yellName() { // <T> generic declaration here is independent of T in class generic
		return (T)(name.toString() + "!");
	}
	
	public void doNothing(List<Object> in) {}
//	public void doNothing(List<String> in) {} // parameterized types are not considered different for overloading/overriding
	public void doNothing(List<String> in, String s) {}
	
	public List<CharSequence> play() {return new ArrayList<>();}
	
	//	public D badGenericMethod(D d) {
	//	return d;
	//}
	public <E> E goodGenericMethod(E e) {
		return e;
	}
	public <Y,Z> T alsoGood(Z xyz) {
		System.out.println((Y) xyz);
		return (T) xyz;
	}
	
	
//	public <F extends G> void first() {}
	public <F extends T> void firstFirst() {}
	public <F extends Number> void otherFirst() {} 
//	public <H> void second(List<I> list) {}
	public <J> void third(List<J> list) {}
//	public <K> void fourth(List<K extends L> list) {}
//	public <K> void otherFourth(List<K extends Object> list) {}
//	public <K> void fifth(List<K extends T> list) {}
	public <K> void sixth(List<? extends K> list) {} 
	
//	List<Exception> exceptions = new ArrayList<IOException>();
	
	// generic type requires formal param <T> declaration
	public <T> void printGeneric(List<T> list) { // example of generic method type <T> independent of class generic type
		for (Object o : list) { 
			System.out.println(o);
		}
	}	
	
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


