package com.qiuxg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFileName {

	/**
	 * @param dir 目标路径
	 */
	List<File> ll = new ArrayList<File>();
	public List<File> getFileName(File file) {
		File[] files = file.listFiles();
		for(File file2 : files) {
			if(file2.isDirectory()) {
				getFileName(file2);
			}else {
				if(file2.getName().endsWith("xlsx")) {
					ll.add(file2);
				}
			}
		}
		return ll;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetFileName gfn = new GetFileName();
		File file = new File("d:\\个人知识管理\\1_项目工作\\10_长沙银行\\01_财富管理系统\\11_mapping\\");
		List<File> l = gfn.getFileName(file);
		for(File file2 : l) {
			System.out.println(file2.getName());
		}
	}

}
