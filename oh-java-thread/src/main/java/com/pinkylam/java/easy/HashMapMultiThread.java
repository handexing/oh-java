package com.pinkylam.java.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:并发下得hashmap
 * @author handx
 * @date 2017年11月22日 上午10:42:42
 * @version V1.0
 */
public class HashMapMultiThread {

	static Map<String,String> map = new HashMap<String,String>();
	
	public static class AddTread implements Runnable {
		int start = 0;
		
		public AddTread(int start) {
			this.start = start;
		}


		@Override
		public void run() {
			for (int i = start; i < 100; i+=2) {
				map.put(Integer.toString(i), Integer.toBinaryString(i));
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new HashMapMultiThread.AddTread(0));
		Thread t2 = new Thread(new HashMapMultiThread.AddTread(1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}

}
