package chapter13.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
//				result.get(10, TimeUnit.SECONDS); // Returns null for Runnable
				result.get(10, TimeUnit.NANOSECONDS); // timeout on the Future result but does NOT timeout the thread in service
				System.out.println(result);
				System.out.println("result.get(): " + result.get()); // get on a Future of a Runnable is always null
				System.out.println("result.isCancelled(): " + result.isCancelled());
				System.out.println("result.isDone(): " + result.isDone());
				System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("counter in catch: " + counter);
			System.out.println("Not reached in time");
		} finally {
			service.shutdown();
		}
		System.out.println("counter after try: " + counter);
		System.out.println("service.isShutdown(): " + service.isShutdown()); // service stops accepting new tasks
		System.out.println("service.isTerminated(): " + service.isTerminated()); // existing tasks may still be executing i.e. not terminated
		service.awaitTermination(2, TimeUnit.SECONDS);
		System.out.println("counter after await: " + counter);		
		System.out.println();
		
		var otherService = Executors.newSingleThreadExecutor();
		try {
			Future<Integer> result = otherService.submit(() -> 30 + 11); // Callable functional interface returns a value
			System.out.println("result.get(): " + result.get()); // 41
		} finally {
			otherService.shutdown();
		}
		
		
	} 
}