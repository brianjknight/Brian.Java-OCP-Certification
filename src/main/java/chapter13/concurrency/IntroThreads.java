package chapter13.concurrency;

public class IntroThreads {

//	private static long count = 0;
	private static volatile long count = 0;
	
	public static void main(String[] args) {
//**********************************************************************************************
		
		Runnable printInventory = () -> System.out.println("Printing zoo inventory");
		Runnable printRecords = () -> {
			for (int i = 0; i < 50_000; i++)
				if (i % 10000 == 0) System.out.println("Printing record: " + i);
		};
		
		// multi-threading results are unknown until runtime 
		System.out.println("begin");
		Thread printThread = new Thread(printInventory);
		Thread printRecordsThread = new Thread(printRecords);
		System.out.println("printRecordsThread state prior to .start(): " + printRecordsThread.getState());
		printRecordsThread.start();
		System.out.println("printRecordsThread state after .start(): " + printRecordsThread.getState());
		printRecordsThread.interrupt(); // only WAITING/TIME_WAITING threads can be interrupted NOT BLOCKED threads
		System.out.println("printRecordsThread state after .interrupt(): " + printRecordsThread.getState());
		System.out.println("printRecordsThread.interrupted(): " + printRecordsThread.interrupted());
		try {
			System.out.println("try block");
			printRecordsThread.sleep(1000);
			System.out.println("printThread state after .sleep(1000)" + printRecordsThread.getState());
		} catch (InterruptedException e) {
			System.out.println("caught InterruptedException");
			System.out.println("printRecordsThread state after .interrupt(): " + printRecordsThread.getState());
			System.out.println("printRecordsThread.interrupted(): " + printRecordsThread.interrupted());
		}
		System.out.println("printThread state after try/catch" + printRecordsThread.getState());
		
		new Thread(printInventory).start();
		System.out.println("end");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		// calling run() does NOT start new threads therefore results are predictable
		System.out.println("begin");
		new Thread(printInventory).run();
		new Thread(printRecords).run();
		new Thread(printInventory).run();
		System.out.println("end");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
//**********************************************************************************************		
		
		// example of polling:
			// 1. comment out interrupt and try/catch in while loop
				// ties up system resources continuously printing "Not reached yet" unknown number of times
			// 2. uncomment try/catch
				// the main() thread with while loop sleeps, but myCounter keeps executing incrementing count
				// "Not yet reached" only called after sleep time until counter hits limit
			// 3. uncomment interrupt
				// when myCounter thread is finished, mainThread is interrupted
				// program is interrupted and terminates before the last full 1_000 millisecond sleep time is finished 
		
		long limit = 1_000_000_000L; // note with higher limit race condition can creates multiple increments resulting in 'count' higher than the limit
		// try using AtomicLong, volatile, synchronized
		
		Thread mainThread = Thread.currentThread();
		
		Thread myCounter = new Thread( () -> { 
			for(int i = 0; i < limit; i++) 
				count++;
				mainThread.interrupt(); // when myCounter thread is done, the program is allowed to interrupt the main method
										// the result is interrupting the sleep 1 second called below
				System.out.println("in for loop > mainThread.getState(): " + mainThread.getState());
				System.out.println("in for loop > mainThread.interrupted(): " + mainThread.interrupted());
			});
		
		myCounter.start();
		
		while(count < limit) { // you don't always know when or if a thread will finish resulting in potentially endless loop
			System.out.println("Not reached yet");   
			
			try {
				mainThread.sleep(1_000);  // sleep on main() thread. when myCounter thread finishes, then the sleeping main thread is interrupted
			} catch (InterruptedException e) {
				System.out.println("Interrupted!"); 
				System.out.println("in for catch > mainThread.getState(): " + mainThread.getState());
				System.out.println("in for catch > mainThread.interrupted(): " + mainThread.interrupted());
			}      
		}      
			
		System.out.println("Reached: "+count);
		
		
		System.out.println();
		
		Thread sewingThread = new Thread(()-> System.out.println(Thread.currentThread().getName()));
		sewingThread.setName("buzz buzz sewing thread");
		Thread.State ts = sewingThread.getState();
		System.out.println("sewingThread state prior to .start(): " + ts);
		System.out.println("sewingThread isAlive(): " + sewingThread.isAlive());
		sewingThread.start();
		System.out.println("sewingThread started");
		System.out.println("sewingThread isAlive(): " + sewingThread.isAlive());
		
		new Thread( ()-> System.out.println(
					"Current thread: " +Thread.currentThread() + " | threadId: " + Thread.currentThread().getId() + " | threadPriority: " + Thread.currentThread().getPriority())
				).start();
		
		new Thread( ()-> System.out.println(Thread.currentThread().getName())
				).start();
		
		System.out.println(Thread.currentThread().getName());
	}
	
}


