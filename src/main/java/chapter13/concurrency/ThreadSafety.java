package chapter13.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafety {
	
	public static void printHello(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			System.out.println("Hello");
			Thread.sleep(1000); // if the locked thread sleeps for too long, the tryLock in main thread might timeout returning false
		} finally {
			lock.unlock();
		} 
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Lock lock = new ReentrantLock();
		
		new Thread(() -> {
			try {
				printHello(lock);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		// the new Thread starts executing and main thread continues 
		// so here calling sleep for 2/10 second allows "Hello" to print first before attempting to acquire next lock
		Thread.sleep(200);  // polling to force main thread to wait so lock is created in printHello() method.
		
		if(lock.tryLock(100, TimeUnit.MILLISECONDS)) { // if first thread takes too long e.g.sleep(1000), this times out 
//		if(lock.tryLock(2000, TimeUnit.MILLISECONDS)) { // first thread sleeps 1 second but timeout here is 2 seconds; lock is able to acquire and return true
			try {
				System.out.println("Lock obtained, entering protected code");
			} 
			finally {
				lock.unlock();
			}
		} else {
			System.out.println("Unable to acquire lock, doing something else");
		}
		
		System.out.println("end main");
	}
}


