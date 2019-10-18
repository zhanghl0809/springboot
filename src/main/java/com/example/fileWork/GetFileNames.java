package com.example.fileWork;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.web.context.request.WebRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * b遍历文件夹下所有的图片的文件
 */
public class GetFileNames {
	public static List<File> getFiles(String path){
		File root = new File(path);
		List<File> files = new ArrayList<File>();
		if(!root.isDirectory()){
			files.add(root);
		}else{
			File[] subFiles = root.listFiles();
			for(File f : subFiles){
				files.addAll(getFiles(f.getAbsolutePath()));
			}
		}
		return files;
	}

	public static void main(String[] args) {
		List<File> files = getFiles("D:\\atupian");
		for(File f : files){
			System.out.println(f.getName());
		}
	}
}
