package chapter13.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {
	private static int counter = 0;
	
	public static void main(String[] unused) throws Exception {
		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			Future<?> result = service.submit(() -> {  // Runnable functional interface void/no return
				for(int i = 0; i < 1_000_000; i++) counter++;
				});
			
				System.out.println(result);
				result.get(10, TimeUnit.SECONDS); // Returns null for Runnable
//				result.get(10, TimeUnit.NANOSECONDS); 
				System.out.println(result);
				System.out.println("result.get(): " + result.get()); // get on a Future of a Runnable is always null
				System.out.println("result.isCancelled(): " + result.isCancelled());
				System.out.println("result.isDone(): " + result.isDone());
				System.out.println("Reached!");
			} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			service.shutdown();
		} 
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