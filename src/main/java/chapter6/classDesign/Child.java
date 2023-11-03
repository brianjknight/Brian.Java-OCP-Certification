package chapter6.classDesign;

public class Child extends Parent{
	// variables are never overridden only hidden
	private Number age = 15;
	
	@Override // annotation not required but can be useful in avoiding erorrs
	public Integer getAge() {
		return super.getAge().intValue() - 20;
	}
	
	// redeclared method, not an override
	private int getSize() {
		return 10;
	}
	
	// hidden method NOT overridden because static makes it a class member not instance member
	public static String greeting() {
		return "hi";
	}
	
	// cannot override final methods. Will not compile
//	public boolean isCitizen() {
//		return true;
//	}

}
