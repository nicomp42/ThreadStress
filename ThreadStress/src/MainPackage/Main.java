/**
 * A simple thread test.
 * Access a shared variable repeatedly to see if the synchronization is configured properly.
 * Interesting modifications:
 * 1. Implement an array of ThreadStress objects instead of n explicitly declared objects
 * 2. Try this: http://wiki.eclipse.org/Thread_Analysis
 */
package MainPackage;

import ThreadStressPackage.ThreadStress;
import Config.Config;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadStress t0 = new ThreadStress();
		ThreadStress t1 = new ThreadStress();
		ThreadStress t2 = new ThreadStress();
		ThreadStress t3 = new ThreadStress();
		ThreadStress t4 = new ThreadStress();
		ThreadStress t5 = new ThreadStress();
		ThreadStress t6 = new ThreadStress();
		ThreadStress t7 = new ThreadStress();
		ThreadStress t8 = new ThreadStress();
		ThreadStress t9 = new ThreadStress();

		// These threads are computationally expensive and will be running concurrently.
		t0.run(); t1.run(); t2.run(); t3.run(); t4.run(); 
		t5.run(); t6.run(); t7.run(); t8.run(); t9.run(); 
		
		// Figure out what should be in the bucket. We ran 5 threads for Config.totalLoops iterations.
		long expectedBucketValue = Config.GetTotalLoops() * 10;
		System.out.println("Expected value is " + expectedBucketValue + " and calculated value is " + ThreadStress.GetBucketValue());
		if (ThreadStress.GetBucketValue() == expectedBucketValue) {
			System.out.println("All is well");
		} else {
			System.out.println("Oops. The expected bucket value is unexpected. Something went wrong");
		}
	}
}
