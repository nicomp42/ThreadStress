/*
 * A Thread is a stand-alone program. 
 * It has no main, rather the entry point is the run() method.
 */
package ThreadStressPackage;
import java.util.Random;

import Config.Config;

public class ThreadStress extends Thread {
	// Declaring this variable as static means that one copy will be shared between all instances of this class.
	private static long bucket = 0;
	
	/**
	 * Entry point for the thread. 
	 */
	public void run() {
		for (int i = 0; i < Config.GetTotalLoops(); i++) {
			IncrementBucket();
		}
	}
	/**
	 * Add one to the bucket. 
	 */
	private void IncrementBucket(){
		long tmp = bucket;
		try {sleep(new Random().nextInt(10));} catch(Exception ex){}	// THIS is a good time to eat an exception
		tmp++;
		bucket = tmp;
	}
	/**
	 * See what's in the bucket.
	 * @return The value in the bucket
	 */
	public static long GetBucketValue() {return bucket;}
}
