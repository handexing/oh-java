package com.pinkylam.java.interrupt;

public class JoinMain {

	public volatile static int i = 0;

	public static class AddThread extends Thread {
		@Override
		public void run() {
			for (i = 0; i < 1000000; i++);
		}
	}

	/**
	 * join()标识无限等待，她会一直阻塞当前线程，知道目标线程执行完毕。
	 * join(long millis)给一个最大的等待时间，如果时间到了目标线程还在执行，当前线程会不等继续往下执行。
	 */
	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.start();
		at.join();//主线程等待AddThread执行完毕
		System.out.println(i);
	}
}
