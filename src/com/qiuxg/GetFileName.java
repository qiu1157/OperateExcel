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
//		File file = new File(dir);
//		//List<File> l = new ArrayList<File>();
//		if(!file.exists()||!file.isDirectory()) {
//			System.out.println("Ŀ¼����ȷ");
//			return null;
//		}
//		File[] files = file.listFiles();
//		for(File file2:files) {
//			if(file2.isFile()) {
//				l.add(file2);
//			}
//		}
		File[] files = file.listFiles();
		for(File file2 : files) {
			if(file2.isDirectory()) {
				getFileName(file2);
			}else {
				ll.add(file2);
			}
		}
		return ll;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetFileName gfn = new GetFileName();
		File file = new File("D:\\����֪ʶ����\\1_��Ŀ����\\10_��ɳ����\\01_�Ƹ�����ϵͳ\\10_�������\\��������mapping\\ACRM");
		List<File> l = gfn.getFileName(file);
		for(File file2 : l) {
			System.out.println(file2.getName());
		}
	}

}
