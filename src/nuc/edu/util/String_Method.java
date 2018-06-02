package nuc.edu.util;

public class String_Method {
	public static String getFileName(String url) {
		String FileName = null;
		
		int i = url.lastIndexOf(".");
		int j = url.lastIndexOf("/");
		
		FileName = url.substring(j+1, i);
		
		return FileName;
	}
	
	public static String getTail(String url) {
		String tail = null;
		
		int i = url.lastIndexOf(".");
		tail = url.substring(i);
		
		return tail;
	}
}
