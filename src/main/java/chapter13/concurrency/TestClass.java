package chapter13.concurrency;

public class TestClass extends Thread {
	   private static int threadcounter = 0;
	   
	   public synchronized void run() {
	      threadcounter++;
	      System.out.println(threadcounter);
	   }
	   
	   public static void main(String[] args) throws Exception {

//		   TestClass tc = new TestClass();
	      
		   for(int i=0; i<10; i++) {
//	         synchronized(TestClass.class) {
//	            new TestClass().start();  // synchronizing creatation of a TestClass not the logic code; also create different instances
//	         }
	    	  
	    	 new TestClass().start(); // still creates new object/thread each time.
	    	 
//	    	 tc.start();
		   }
	   }
}
