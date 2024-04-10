package chapter11.exceptionsLocalizations;


public class MyFileClass implements AutoCloseable{
	
	private final int num;
	
	public MyFileClass(int num) { 
		System.out.println("Instantiating MyFileClass object with num: " + num);
		this.num = num; 
	}
	
	@Override 
	public void close() {
		System.out.println("Closing: " + num);
	} 
	
}


