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
		File file = new File("d:\\����֪ʶ����\\1_��Ŀ����\\10_��ɳ����\\01_�Ƹ�����ϵͳ\\11_mapping\\");
		List<File> l = gfn.getFileName(file);
		for(File file2 : l) {
			System.out.println(file2.getName());
		}
	}

}
