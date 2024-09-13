package chapter9.collectionsGenerics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generics<T, U, hamburger, _H0tdo9s extends Number> { // follows naming convention of variables
	private T name;
	private U age;
	private hamburger bigMac;
//	private static _H0tdo9s oscarMeyer; // static reference to non-static type
	
	public Generics() {}
	
	public Generics (T t, U u) {
		this.name = t;
		this.age = u;
	}
	
	public T getName() {return name;}
	public U getAge() {return age;}
	
	public <T> T yellName() { // <T> formal generic param here shadows T in class generic
		return (T)(name.toString() + "!");
	}
	
	public T whisperName() { // T here is generic of class
		return (T) name.toString().toLowerCase();
	}
	
	public void doNothing(List<Object> in) {}
//	public void doNothing(List<String> in) {} // parameterized types are not considered different for overloading/overriding
	public void doNothing(List<String> in, String s) {}
	
	public List<CharSequence> play() {return new ArrayList<>();}
	
	//	public D badGenericMethod(D d) { // generic type D is not declared
	//	return d;
	//}
	public <E> E goodGenericMethod(E e) {
		return e;
	}
	public <Y,Z> T alsoGood(Z xyz) {  // T here is of class generic T
		System.out.println((Y) xyz);
		return (T) xyz;
	}
	
	
//	public <F extends G> void first() {}
//	public <F super Number> void first() {} // super only used with wildcard ? not for bounding generics
	public <F extends T> void firstFirst() {} // declaring type F used within this method must extend T declared in class
	public <F extends Number> void otherFirst() {} 
	public <F extends Number> F notFirst(F in) {
		return null;
	} 
	public <F extends Number & Comparable<T> & Runnable> void multiBounded() {}
//	public <? extends Number> void otherFirstXXX() {} // cannot use wildcard for declaring parameterized types of method or class
//	public <H> void second(List<I> list) {}
	public <J> void third(List<J> list) {}
//	public <K> void fourth(List<K extends L> list) {}
//	public <K> void otherFourth(List<K extends Object> list) {}
//	public <K> void fifth(List<K extends T> list) {}
	public <K> void sixth(List<? extends K> list) {} 
	public <K> void seventh(List<? super K> list) {} 
	
//	List<E extends Number> genericList; // typed generics are NOT allowed for declaring VARIABLES (are allowed declaring class and methods)
//	List<T extends Number> genericFromClassList; // does not compile
	List<? extends Number> wildList;
//	wildList = new ArrayList<Integer>(); // wildList is immutable
	
//	List<Exception> exceptions = new ArrayList<IOException>();
	List<Exception> exceptions = new ArrayList<Exception>();
	
	// generic type requires formal param <T> declaration
	public <T> void printGeneric(List<T> list) { // example of generic method type <T> independent of class generic type
		for (Object o : list) { 
			System.out.println(o);
		}
	}	
	
	public static void main(String[] args) {
		Generics omitDiamond = new Generics<String, Integer, Object, Number>("Brian", 39);  // DECLARATION OMITS <> AND PARAM TYPES java infers both as Object
//		System.out.println(omitDiamond.getName() + omitDiamond.getAge()); // does not compile '+' operator undefined for Object
		System.out.println(omitDiamond.getName()); // works because Object is the reference type but implementation is String toString() method 
		System.out.println(omitDiamond.getName().toString() + omitDiamond.getAge().toString()); 
		
		Generics<String, Integer, Object, Number> includeParamTypes = new Generics<>("Brian", 39);
		// TYPE ERASURE after Java compiles all generics are Objects, however the compilier adds relevant casting behind the scenes for declared type
		// now  getName() is cast as a String and getAge() cast as Integer, so operator works with operator using Integer.toString()
		System.out.println(includeParamTypes.getName().toUpperCase() + includeParamTypes.getAge().doubleValue()); 
		
		// Java infers Object for parameterized type when omitted
		List list = new ArrayList(); 
		List anotherList = new ArrayList<>(); 
		List yetAnotherList = new ArrayList<String>();
		
		list.add("cat");
		list.add(9);
		list.add(false);
		
		list.forEach(o -> System.out.println(o + " | " + o.getClass()));
		
//		System.out.println(list.get(0) + list.get(1)); // does not compile since '+' operator cannot be used for Object
		System.out.println(" " + list.get(0) + list.get(1)); // java infers string from " " + and uses Object toString()
		
//		List<> badList = new ArrayList<Integer>(); // diamond operator requires a type for declaration
		
		List intList = new ArrayList<Integer>(); // Java still infers Object type when declaration <> is omitted
		intList.add("1");
		intList.add(2);
		intList.add(3.0);
		System.out.println(intList);
		
		
//		List<Object> objList = new ArrayList<Integer>(); // not allowed to mix types even if a sub type
		List<? extends Object> objList = new ArrayList<Integer>();
		List<Object> oList = new ArrayList<>();
		List<Integer> sList = new ArrayList<Integer>();
//		oList = sList;  								// same compile error
		
		System.out.println();
//		System.out.println(averageN(new ArrayList<Double>())); // generics are invariant i.e. NOT covariant (different than bounded generic)
		System.out.println(averageExN(new ArrayList<Double>()));
		System.out.println();
		
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList rawList = (ArrayList) al;  // equivalent to ArrayList<Object> rawList but pointing to same object on the heap ArrayList<String>
		rawList.add("string"); // type safety is lost and allowed to add a string
//		Integer i = al.get(0); // runtime exception
//		String s = al.get(0); // does not compile
		System.out.println(al.get(0)); 
	}
	
	static double averageN(List<Number> list){
		double sum = 0.0;
		for(Number n : list){ sum += n.doubleValue(); }
		return sum/list.size();
	}
	static <E extends Number> double averageExN(List<E> list){
		double sum = 0.0;
//		list.add(10.0); // E could be List<Double> now which will not accept an Integer or int primitive
//		List<Double> dList = new ArrayList<>();
//		list.add(Integer.valueOf(10));
		
		Double d = 10.0;
		list.add((E)d); // must cast to generic type to add to list
		
		double dPrim = 10;
		for(Number n : list){ sum += n.doubleValue(); }
		return sum/list.size();
	}
	static double averageWildcard(List<? extends Number> list){ // equivalent to averageExN()
		double sum = 0.0;
		for(Number n : list){ sum += n.doubleValue(); }
		return sum/list.size();
	}
	
}


