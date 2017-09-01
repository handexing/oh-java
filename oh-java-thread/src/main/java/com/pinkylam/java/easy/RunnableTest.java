package com.pinkylam.java.easy;

/**
 * @Description: 实现Runnable接口
 * @author handx  
 * @date 2017年8月31日 上午10:02:03 
 * @version V1.0
 */
public class RunnableTest implements Runnable {
	
	private int ticket = 5;

	public void run() {
		for (int i = 0; i < 10; i++) {
			if (ticket > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ticket = " + ticket--);
			}
		}

	}

}

/**
 * new了三个Thread线程对象，公用一个Runnable对象，三个线程共同卖票任务。
 * 三个线程共同执行Runnable对象中的代码，因此线程不安全。ticket会输出-1，
 * 这种情况的出现是由于，一个线程在判断 ticket 为 1>0 后，还没有来得及减 1，另一个线程已经将 ticket 减 1，变为了 0，那么接下来之前的线程再将 ticket 减 1，便得到了 -1。
 * 这就需要加入同步操作（即互斥锁），确保同一时刻只有一个线程在执行每次 for 循环中的操作。
 * 而在第一种方法中，并不需要加入同步操作，因为每个线程执行自己 Thread 对象中的代码，不存在多个线程共同执行同一个方法的情况。
 */
class RunnableDemo {
	public static void main(String[] args) {
		RunnableTest runnable = new RunnableTest();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
	}
}