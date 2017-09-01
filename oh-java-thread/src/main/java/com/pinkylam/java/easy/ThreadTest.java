package com.pinkylam.java.easy;

/**
 * @Description: 继承thread类
 * @author handx  
 * @date 2017年8月31日 上午9:59:42 
 * @version V1.0
 */
public class ThreadTest extends Thread {

	private int ticket = 5;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (ticket > 0) {
				System.out.println("ticket = " + ticket--);
			}
		}
	}
}

/**
 * 开启了三个线程，每个线程单独卖了 5 张票.
 */
class ThreadDemo {
	public static void main(String[] args) {
		new ThreadTest().start();
		new ThreadTest().start();
		new ThreadTest().start();
	}
}
