package com.pinkylam.java.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Description:并发下得arraylist
 * @author handx
 * @date 2017年11月22日 上午10:42:42
 * @version V1.0
 */
public class ArrayListMultiThread {

//	static List<Integer> list = new ArrayList<Integer>(10);
	
	//使用线程安全得Vector代替list
	static Vector<Integer> list = new Vector<Integer>(10);
	 

	public static class AddTread implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				list.add(i);
			}
		}

	}

	/**
	 * 期望最后list为200，但是并没有：
	 * 1、正常结束，list有200个元素。
	 * 2、抛异常，java.lang.ArrayIndexOutOfBoundsException 扩容过程内部一致性被破坏，
	 * 没有锁得保护，另一个线程访问到了不一致得内部状态。导致越界。
	 * 3、打印值得大小——156。由于多线程访问冲突，两个线程同时对list中得同一个位置得值赋值。
	 * 
	 * 改进：
	 * 	使用线程安全得vector代替list
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddTread());
		Thread t2 = new Thread(new AddTread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(list.size());
	}

}
