package com.pinkylam.java.interrupt;

public class DaemonDemo extends Thread {

	/**
	 * 守护线程是一种特殊的线程，是系统的守护者，在后台默默完成系统性的服务，比如垃圾回收。
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new DaemonDemo();
		t.setDaemon(true);
		t.start();
		Thread.sleep(2000);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("i am alive");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
