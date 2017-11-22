package com.pinkylam.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小的线程池
 */
public class ThredPoolDemo {

	public static class MyTask implements Runnable {

		public void run() {
			System.out.println(System.currentTimeMillis() + " Thread ID:" + Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		MyTask task = new MyTask();
		// 新建5个固定线程
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			es.submit(task);
		}

	}

}
