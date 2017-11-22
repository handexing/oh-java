package com.pinkylam.java.executor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 重入锁
 * @author handx
 * @date 2017年11月22日 上午11:18:00
 * @version V1.0
 */
public class ReenterLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 100; j++) {
			//使用重入锁保护临界区资源i
			lock.lock();//手动加锁
			try {
				i++;
			} finally {
				lock.unlock();//手动释放锁，不然其他线程没有机会在访问临界区
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock tl = new ReenterLock();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(t1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
