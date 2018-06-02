package nuc.edu.util;

public class PrletterIsShow {

	public static boolean prletterIsShow( String fromEmail , String toEmail ) {
		
		boolean flag = false;
		
		String[] str = toEmail.split("-");
		
		for( int i = 0 ; i < str.length ; i ++ ) {
			
			if( str[i].equals( fromEmail ) && str[i+1].equals("0") ) {
				
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}
	
}
