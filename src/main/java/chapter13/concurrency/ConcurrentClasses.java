package chapter13.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ConcurrentClasses {

	static int total = 0;
	
	public static void main(String[] args) {
		
		System.out.println(List.of("w", "o", "l", "f","a","b","c","d","e","f")
				.parallelStream()
				.reduce("", (s1,c) -> s1 + c, (s2,s3) -> s2 + s3));
//				.reduce("", (s1,c) -> s1 + c));
//				.reduce("x", (s1,c) -> s1 + c, (s2,s3) -> s2 + s3));
	
		
		IntStream.range(1,10).forEach(i -> total += i);
		System.out.println(total);
		
		ExecutorService service = Executors.newSingleThreadScheduledExecutor();
//		service.scheduleWithFixedDelay(() -> { // lose access to scheduled methods
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


