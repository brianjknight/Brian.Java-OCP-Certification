package chapter13.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
	private void removeLions() { 
		System.out.println("Removing lions");
	}
	private void cleanPen()	{ 
		System.out.println("Cleaning the pen"); 
	}
	private void addLions(){ 
		System.out.println("Adding lions");
	}
	
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeLions(); // current manager/object removes lions
			c1.await(); // each the barrier awaits for number of completed threads in this case 4
			cleanPen();
//			c1.await(); // can be reused; won't use Runnable "pen cleaned!"
			c2.await();
			addLions();
		} catch (InterruptedException | BrokenBarrierException e) {
		// Handle checked exceptions here
		}
	}
	
	public static void main(String[] args) {
//		var service = Executors.newFixedThreadPool(2); // program hangs waiting for 3rd and 4th thread that are never created
		var service = Executors.newFixedThreadPool(10);
		try {
			var tcbObject = new TestCyclicBarrier();
			var c1 = new CyclicBarrier(4);
			var c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
			for (int i = 0; i < 4; i++)
				service.submit(() -> tcbObject.performTask(c1, c2)); // each thread has the same CyclicBarrier instances
		} finally {
			service.shutdown();
		} 
	} 
	
}

class LionPenManager {
	// pg 751
}
