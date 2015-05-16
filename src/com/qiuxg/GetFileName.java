package com.qiuxg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFileName {

	/**
	 * @param dir Ŀ��·��
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
		File file = new File("e:\\个人知识管理\\1_项目工作\\11.华兴银行\\02.工程库\\03.编码实现\\01 Mapping\\G层\\G_LN\\");
		List<File> l = gfn.getFileName(file);
		for(File file2 : l) {
			System.out.println(file2.getName());
		}
	}

}
