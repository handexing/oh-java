package com.pinkylam.java.interrupt;

/**
 * @Description:中断线程
 * @author handx  
 * @date 2017年11月9日 下午3:00:37 
 * @version V1.0
 */
public class InterruptDemo {
	
	/**
	 * interrupt(); 通知目标线程中断，设置中断表示位。
	 * isInterrupted();判断当前线程是否被中断。
	 * Thread.interrupted();判断当前线程得中断状态，同事清除当前线程得终端标识。
	 */

	public static void main(String[] args) throws InterruptedException {
		
		//虽然已经调用interrupt方法，但是t1并没有中断处理逻辑，
		//只是被设置了中断标识。并不会有任何作用。
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					//判断当前线程是否被中断，如果是，退出！
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("interrupted");
						break;
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		System.out.println("interrupt");
		t1.interrupt();
	}
}
