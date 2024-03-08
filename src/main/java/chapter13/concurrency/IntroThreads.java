package chapter13.concurrency;

public class IntroThreads {

	private static long count = 0;
	
	public static void main(String[] args) {
		Runnable printInventory = () -> System.out.println("Printing zoo inventory");
		Runnable printRecords = () -> {
			for (int i = 0; i < 3; i++)
				System.out.println("Printing record: " + i);
		};
		
		// multi-threading results are unknown until runtime 
//		System.out.println("begin");
//		new Thread(printInventory).start();
//		new Thread(printRecords).start();
//		new Thread(printInventory).start();
//		System.out.println("end");
//		System.out.println();
		
		// calling run() does NOT start new threads therefore results are predictable
//		System.out.println("begin");
//		new Thread(printInventory).run();
//		new Thread(printRecords).run();
//		new Thread(printInventory).run();
//		System.out.println("end");
		
		
		// example of polling:
			// 1. comment out interrupt and try/catch in while loop
				// ties up system resources continuously printing "Not reached yet" unknown number of times
			// 2. uncomment try/catch
				// the main() thread with while loop sleeps, but myCounter keeps executing incrementing count
				// "Not yet reached" only called after sleep time until counter hits limit
			// 3. uncomment interrupt
				// when myCounter thread is finished, mainThread is interrupted
				// program is interrupted and terminates before the last full 1_000 millisecond sleep time is finished 
		
		long limit = 1_000_000_000L;
		
		Thread mainThread = Thread.currentThread();
		
		Thread myCounter = new Thread( () -> { 
			for(int i = 0; i < limit; i++) 
				count++;
				mainThread.interrupt(); // when myCounter thread is done, the program is allowed to interrupt the main method
										// the result is interrupting the sleep 1 second called below
			});
		
		myCounter.start();
		
		while(count < limit) { // you don't always know when or if a thread will finish resulting in potentially endless loop
			System.out.println("Not reached yet");         
			try {            
				mainThread.sleep(1_000);  // sleep on main() thread. when myCounter thread finishes, then the sleeping main thread is interrupted
//				myCounter.sleep(1_000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted!");         
			}      
		}      
			
		System.out.println("Reached: "+count);
		
	}
	
}


