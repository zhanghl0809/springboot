package com.example.fileWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

public class IndexOF {
	public static void main(String[] args) throws Exception {
		String[] urls = DownAndReadFile("http://172.30.1.42/aipc/");

		if (urls != null) {
			for (String url : urls) {
				System.out.println(url);

			}
			String str = getFileContent("http://172.30.1.42/aipc/2019.zip");
			System.out.println("---"+str);
		}
	}

	/**
	 * 远程下载文件并读取返回p
	 *
	 * @param filePath 文件网络地址 如 http://www.baidu.com/1.txt
	 * @return String
	 * @throws IOException
	 */
	public static String[] DownAndReadFile(String filePath) throws IOException {
		HttpURLConnection uc = null;
		InputStream iputstream = null;
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		String[] fileArr = null;
		try {
			URL url = new URL(filePath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
			uc.connect();
			iputstream = uc.getInputStream();
			in = new BufferedReader(new InputStreamReader(iputstream, "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			String nginxStr = buffer.toString();
			Parser parser = new Parser(nginxStr);
			NodeFilter filter = new HasAttributeFilter("a");
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			for (int i = 1; i < nodes.size(); i++) {
				Node node = nodes.elementAt(i);
				sb.append(node.toPlainTextString() + " ");
			}
			fileArr = sb.toString().split(" ");
			for (int j = 0; j < fileArr.length; j++) {
				fileArr[j] = filePath + fileArr[j];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (iputstream != null) {
				iputstream.close();
				iputstream = null;
			}
		}
		return fileArr;
	}

	public static String getFileContent(String filePath) throws IOException {
		String str = "";
		HttpURLConnection uc = null;
		BufferedReader in = null;
		InputStream iputstream = null;
		try {
			URL url = new URL(filePath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
			uc.connect();
			iputstream = uc.getInputStream();
			in = new BufferedReader(new InputStreamReader(iputstream, "gbk"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			str = buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (iputstream != null) {
				iputstream.close();
				iputstream = null;
			}
		}
		return str;
	}

}
