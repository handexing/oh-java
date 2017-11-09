package org.oh.java.basics;

/**
 * @Description: 自动递增和递减
 * @author handx
 * @date 2017年9月7日 下午2:59:16
 * @version V1.0
 */
public class AutoInc {

	// 前缀形式，执行完运算后才得到值。
	// 后缀形式，则是在运算执行之前就得到值。
	public static void main(String[] args) {
		int i = 1;
		System.out.println("i : " + i);
		System.out.println("++i : " + ++i); // Pre-increment
		System.out.println("i++ : " + i++); // Post-increment
		System.out.println("i : " + i);
		System.out.println("--i : " + --i); // Pre-decrement
		System.out.println("i-- : " + i--); // Post-decrement
		System.out.println("i : " + i);
	}

}
