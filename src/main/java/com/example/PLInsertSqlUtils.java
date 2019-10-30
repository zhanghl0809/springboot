package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.MessageFormat;
import java.util.ArrayList;

public class PLInsertSqlUtils {
	public static void main(String[] args) {
//		File file = new File("D:\\mgc.txt");
//		System.out.println(file.exists());
//		toArrayByRandomAccessFile("D:\\mgc.txt");
		String str = String.format("%s张%s元代金券已经到账，折后抵扣更优惠！微信搜索”%s”小程序，使用本手机号登录立即使用。", "3", "50", "惠盈宝");
		System.out.println(str);
	}

	public static void toArrayByRandomAccessFile(String name) {
		// 使用ArrayList来存储每行读取到的字符串
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			File file = new File(name);
			RandomAccessFile fileR = new RandomAccessFile(file, "rw");
			// 按行读取字符串
			String str = null;
			while ((str = fileR.readLine()) != null) {
				arrayList.add(str);
			}
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对ArrayList中存储的字符串进行处理
		try {
			RandomAccessFile fileRe = new RandomAccessFile(new File(name), "rw");
			int i = 0;
			for (String str : arrayList) {
				if (i == 0) {
					fileRe.writeBytes("DELETE FROM tb_sensitive WHERE VALUE in ('"+str+"', ");
				}else {
					if(i == arrayList.size()-1){
						fileRe.writeBytes("'"+str+"');");
					}else {
						fileRe.writeBytes("'"+str+"',");
					}
				}
				i++;
			}
			fileRe.close();
			System.out.println("转换完成！！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
