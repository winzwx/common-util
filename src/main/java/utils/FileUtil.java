package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	/**
	 * @Title: getExtName   
	 * @Description: �ļ���չ��
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getExtName(String str) {
		if(StringUtil.isNull(str)) {
			return null;
		}
		if(!str.contains(".")) {
			throw new RuntimeException("�޷���ȡ�ļ���չ��");
		}
		return str.substring(str.indexOf("."));
	}
	/**
	 * @Title: delete   
	 * @Description: �ݹ�ɾ���ļ�   
	 * @param: @param file      
	 * @return: void      
	 * @throws
	 */
	public static void delete(File file) {
		/** ��ȡ�ļ��б� **/
		File[] listFiles = file.listFiles();
		for(File theFile : listFiles) {
			/** ������ļ��У��ݹ�ɾ�� **/
			if(theFile.isDirectory()) {
				delete(theFile);
				/** ɾ�����ļ��� **/
				theFile.delete();
			}else {
				/** ������ļ���ֱ��ɾ�� **/
				theFile.delete();
			}
			
		}
	}
	/**
	 * @Title: delete   
	 * @Description: �ݹ�ɾ���ļ�   
	 * @param: @param pathname      
	 * @return: void      
	 * @throws
	 */
	public static void delete(String pathname) {
		delete(new File(pathname));
	}
	/**
	 * ��ȡϵͳ��ǰ�û�Ŀ¼
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	/**
	 * @Title: getSystemTempDirectory   
	 * @Description: ����ϵͳ��ʱĿ¼
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	/**
	 * @Title: getFileSize   
	 * @Description: ����ļ���С
	 * �����ļ���ָ����λ��С��ʾ
	 * File a.txt=2k  
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
		return String.format("%.2f",len)+"kb";
	}
	/**
	 * @Title: readTextFile   
	 * @Description: TODO(������һ�仰�����������������)   
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(File file) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			do {
				String readLine = br.readLine();
				sb.append(readLine);
				sb.append("\r\n");
			}while(br.read()!=-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			StreamUtil.close(br);
		}
		return sb.toString();
	}
	/**
	 * @Title: readTextFileToList   
	 * @Description: ��ȡ�ı��ļ���list   
	 * @param: @param file
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileToList(File file) {
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			do {
				String readLine = br.readLine();
				list.add(readLine);
			}while(br.read()!=-1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			StreamUtil.close(br);
		}
		return list;
	}
	/**
	 * @Title: readTextFileToList   
	 * @Description: ��ȡ�ı��ļ���list   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileToList(String pathname){
		return readTextFileToList(new File(pathname));
	}
	
	public static void main(String[] args) {
		String systemUserHome = getSystemTempDirectory();
		System.out.println(systemUserHome);
		Object len;
		String format = String.format("String.format���ԣ�%s�̶̵�,%s",1,2);
		File file = new File("C:\\Users\\Administrator\\Desktop\\pom.xml");
		System.out.println(readTextFileToList(file));
	}
}
