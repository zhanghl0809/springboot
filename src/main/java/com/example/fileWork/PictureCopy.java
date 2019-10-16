package com.example.fileWork;

import java.io.*;
import java.net.URL;

public class PictureCopy {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://172.30.1.42/aipc/2019/05/09/0b6886dee34ec062bb32d6d0ec197b4b.png");
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			StringBuffer sb = new StringBuffer("");
			int len = 0;
			byte[] temp = new byte[1024];
			while ((len = bis.read(temp)) != -1) {
				sb.append(new String(temp, 0, len));
			}
			sb.toString();
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
