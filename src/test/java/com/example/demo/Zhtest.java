package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Zhtest {

	public static final char[] array =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
					'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
					'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D',
					'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

	public static Map<Character, Integer> charValueMap = new HashMap<Character, Integer>();

	//初始化map
	static {
		for (int i = 0; i < array.length; i++) charValueMap.put(array[i], i);
	}


	public static void main(String[] args) {
		// for (int i = 0; i < 100; i++) {
		// 	long number = Long.MAX_VALUE - i;
		// 	String decimalStr = numberConvertToDecimal(number, 62);
		// 	System.out.println(number  + " 转换成 " + decimalStr);
		// 	long toNumber = decimalConvertToNumber(decimalStr, 62);
		// 	System.out.println(decimalStr + " 转换成 " + toNumber);
		// }
		ArrayList<Pai> list = new ArrayList<>();
		Pai p;
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				p = new Pai();
				p.setKey(String.valueOf(i));
				if(j == 1){
					p.setBefor("");
				}else {
					int bj=j-1;
					p.setBefor(String.valueOf(bj));
				}

				if(j == 13){
					p.setAfter("");
				}else {
					int aj = j+1;
					p.setAfter(String.valueOf(aj));
				}

				switch (j){
					case 1:
						p.setVal("红桃"+i);
						break;
					case 2:
						p.setVal("黑桃"+i);
						break;
					case 3:
						p.setVal("方片"+i);
						break;
					case 4:
						p.setVal("梅花"+i);
						break;
					default:
						System.out.println("造牌异常。。。。");
						break;
				}
				list.add(p);
			}

		}
		Pai p1 = new Pai();
		p1.setKey("14");
		p1.setVal("大王");
		list.add(p1);

		Pai p2 = new Pai();
		p2.setKey("14");
		p2.setVal("小王");
		list.add(p2);

		System.out.println("========================================================");
		for (Pai pai : list) {
			System.out.println(pai.getKey()+"---"+pai.getVal());
		}
		System.out.println("========================================================");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Collections.shuffle(list);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#########################################################");
		for (Pai pai : list) {
			System.out.println(pai.getKey()+"---"+pai.getVal());
		}
		System.out.println("#########################################################");


	}


	/**
	 * 把数字转换成相对应的进制,目前支持(2-62)进制
	 *
	 * @param number
	 * @param decimal
	 * @return
	 */
	public static String numberConvertToDecimal(long number, int decimal) {
		StringBuilder builder = new StringBuilder();
		while (number != 0) {
			builder.append(array[(int) (number - (number / decimal) * decimal)]);
			number /= decimal;
		}
		return builder.reverse().toString();
	}

	/**
	 * 把进制字符串转换成相应的数字
	 * @param decimalStr
	 * @param decimal
	 * @return
	 */
	public static long decimalConvertToNumber(String decimalStr, int decimal) {
		long sum = 0;
		long multiple = 1;
		char[] chars = decimalStr.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			char c = chars[i];
			sum += charValueMap.get(c) * multiple;
			multiple *= decimal;
		}
		return sum;
	}
}
