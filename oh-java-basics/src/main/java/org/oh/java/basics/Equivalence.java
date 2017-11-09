package org.oh.java.basics;

/**
 * @Description:检查对象是否相等
 * @author handx  
 * @date 2017年9月7日 下午3:08:45 
 * @version V1.0
 */
public class Equivalence {

	//而==和!=比较的是对象句柄。输出结果实际上先是false，再是true。
	public static void main(String[] args) {
		Integer n1 = new Integer(47);
		Integer n2 = new Integer(47);
		System.out.println(n1 == n2);
		System.out.println(n1 != n2);
	}

}
