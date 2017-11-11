package com.pinkylam.java.interrupt;

public class AccountingVol implements Runnable {

	static AccountingVol instance = new AccountingVol();
	static volatile int i = 0;//synchronized可以代替volatile的功能

	//synchronized可以直接作用于静态方法
	//public static void increase();
	public synchronized static void increase() {
		i++;
	}

	/**
	 * 线程安全，synchronized:实现线程间的同步，
	 * 对同步代码加锁，使得每次只有一个线程能进入同步快，从而保证线程间的安全性。
	 * synchronized用法：
	 * 1、指定对象加锁：给定对象加锁，进入同步代码前要获得给定的对象锁。
	 * 2、直接作用于实例方法：相当于给当前实例加锁，进入同步代码前要获取当前实例的锁。
	 * 3、直接作用于静态方法：相当于对当前类加锁，进入同步代码钱要获得当前类的锁。
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start(); 
		t1.join();
		t2.join();
		System.out.println(i);
	}

	public void run() {
		for (int j = 0; j < 10000; j++) {
			synchronized (instance) {
				System.out.println("线程名称："+Thread.currentThread().getName());
				increase();
			}
		}
	}

}
