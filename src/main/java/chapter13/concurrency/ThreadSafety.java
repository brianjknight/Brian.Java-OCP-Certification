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
		
		Thread helloThread = new Thread(() -> {
			try {
				printHello(lock);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		helloThread.start();
		
		// the new Thread starts executing and main thread continues
		// however there is no guarantee of happens-first relationship between threads
//		Thread.sleep(200);  // by polling main thread, it give helloThread time to acquire the lock
		
//		if(lock.tryLock(100, TimeUnit.MILLISECONDS)) { // if first thread takes too long e.g.sleep(1000), this times out 
		if(lock.tryLock(2000, TimeUnit.MILLISECONDS)) { // first thread sleeps 1 second but timeout here is 2 seconds; lock is able to acquire and return true
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


