package com.xmln.test;

class A {
	public static void main(String[] args) {
		String s1 = "你", s2 = "α";
		try{
			byte[] b = s1.getBytes("UTF-8");
			System.out.println("汉字\'你\'的UTF-8编码：");
			for(int k=0;k<b.length;k++){
				String str = Integer.toBinaryString(b[k]);
				str = str.substring(str.length()-8);
				System.out.println(" "+str);
			}
			byte c[] = s2.getBytes("UTF-8");
			System.out.println("");
			System.out.println("希腊字母\'α\'的UTF-8编码：");
			for(int k=0;k<c.length;k++){
				String str = Integer.toBinaryString(c[k]);
				str = str.substring(str.length()-8);
				System.out.println(" "+str);
			}
		}catch (Exception e) {
			
		}
	}

}
