package com.TestXml.Test;

import java.util.HashMap;
import java.util.Scanner;


public class testaa {

	public static void main(String[] args) {
		HashMap<Integer, String> tbale = new HashMap<Integer, String>();
		tbale.put(1,"壹");
		tbale.put(2,"贰");
		tbale.put(3,"叁");
		tbale.put(4,"肆");
		tbale.put(5,"伍");
		tbale.put(6,"陆");
		tbale.put(7,"柒");
		Scanner s = new Scanner(System.in);
		System.out.print("请输入一个1到7的整数:");
		int a = s.nextInt();
		System.out.println("大写为：" + tbale.get(a));
	}
}
