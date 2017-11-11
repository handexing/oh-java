package com.pinkylam.java.interrupt;

public class ThreadGroupName implements Runnable {

	//线程组
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("PrintGroup");
		Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
		Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());//获取线程的总数，由于线程是动态，只是一个估计值
		tg.list();//打印线程的信息
	}

	public void run() {
		String name = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
		while (true) {
			System.out.println(name);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
