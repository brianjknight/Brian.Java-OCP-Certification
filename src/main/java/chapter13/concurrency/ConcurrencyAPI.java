package chapter13.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyAPI {
	private static int counter = 0;
	
	public static void main(String[] unused) throws Exception {
		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			Future<?> result = service.submit(() -> {  // Runnable functional interface void/no return
					for(int i = 0; i < 1_000_000; i++) counter++;
				});
			
				System.out.println(result);
				result.get(3, TimeUnit.SECONDS); // Returns null for Runnable; can throw checked exception
//				result.get(10, TimeUnit.NANOSECONDS); // timeout on the Future result but does NOT timeout the thread in service
				System.out.println(result);
				System.out.println("result.get(): " + result.get()); // now waits for future result; get on a Future of a Runnable is always null
				System.out.println("result.isCancelled(): " + result.isCancelled());
				System.out.println("result.isDone(): " + result.isDone());
				System.out.println("Reached!");
		} 
		catch (TimeoutException e) {
			System.out.println("counter in catch: " + counter);
			System.out.println("Not reached in time");
		} 
		finally {
			service.shutdown();
		}
		System.out.println("counter after try: " + counter); // thread is still running if future throws error
		System.out.println("service.isShutdown(): " + service.isShutdown()); // service stops accepting new tasks
		System.out.println("service.isTerminated(): " + service.isTerminated()); // existing tasks may still be executing i.e. not terminated
		service.awaitTermination(2, TimeUnit.SECONDS); // can throw checked exception
		System.out.println("counter after await: " + counter);	
		System.out.println("service.isTerminated() after awaitTermination(): " + service.isTerminated());
		System.out.println();
//		service.submit(() -> System.out.println("Hello")); // submitting to shutdown service throws exception
		
		var otherService = Executors.newSingleThreadExecutor();
		try {
			Future<Integer> result = otherService.submit(() -> 30 + 11); // Callable functional interface returns a value
			System.out.println("result.get(): " + result.get()); // 41
		} finally {
			otherService.shutdown();
		}
		
		System.out.println("otherService.isTerminated(): " + otherService.isTerminated());
		System.out.println("thread sleep...");
		Thread.sleep(1000);
		System.out.println("otherService.isTerminated(): " + otherService.isTerminated());
		System.out.println();
		
		ExecutorService excutorService = Executors.newSingleThreadScheduledExecutor();
//		excutorService.scheduleWithFixedDelay(() -> { // lose access to scheduled methods
//			System.out.println("Open Zoo");
////			return null; // w2
//			}, 0, 1, TimeUnit.MINUTES);

		
		ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();
		scheduledService.scheduleWithFixedDelay(() -> { 
			System.out.println("Open Zoo");
//			return null; // takes a Runnable void not Callable with return
		}, 1, 2, TimeUnit.SECONDS);
	} 
}