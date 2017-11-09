package com.pinkylam.java.interrupt;

/**
 * 简单得实用wait()\notify()
 */
public class SimpleWN {

	final static Object object = new Object();

	public static class T1 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T1 START");
				try {
					System.out.println(System.currentTimeMillis() + ":T1 WAIT");
					object.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + ":T1 end");
			}
		}
	}

	public static class T2 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T2 START.NOTITY ONE THREAD");
				object.notify();
				System.out.println(System.currentTimeMillis() + ":T2 end");
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * T1会先申请object得对象锁，T1执行wait方法之后会释放object的锁并进行等待。
	 * T2在执行notify之前也会得到object的对象锁。唤醒了T1打印 “T1 end”
	 * 
	 * wait和sleep方法都可以让线程等待若干时间。除了wait可以被唤醒之外。
	 * 另一个区别就是wait会释放目标对象的锁，sleep方法不会释放任何资源。
	 */
	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}

}
