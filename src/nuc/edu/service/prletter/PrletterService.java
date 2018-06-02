package nuc.edu.service.prletter;

import java.util.List;

import nuc.edu.dao.prletter.PrletterDaoImpl;
import nuc.edu.entity.Prletter;
import nuc.edu.entity.Teacher;

public class PrletterService {

	static PrletterDaoImpl prletterDao = new PrletterDaoImpl();
	
	public static String queryStudentEmailBySno( String sno ) {
		
		return prletterDao.queryStudentEmailBySno( sno );
		
	}
	
	public static String queryTeacherEmailByTno( String tno ) {
		
		return prletterDao.queryTeacherEmailByTno( tno );
		
	}
	
	public static List<Prletter> querySendInfo( String senderEmail ) {
		
		return prletterDao.querySendInfo( senderEmail );
		
	}
	
	public static List<Prletter> queryReceiveInfo( String receiveEmail ) {
		
		return prletterDao.queryReceiveInfo( receiveEmail );
		
	}
	
	public static List<Teacher> queryTeacherInfoByMajorId( int majorId ) {
		
		return prletterDao.queryTeacherInfoByMajorId( majorId );
		
	}
	
	public static String queryEmailByCourseId( int courseId ) {
		
		return prletterDao.queryEmailByCourseId( courseId );
		
	}
	
	public static List<Prletter> queryAnswerByPrletterTitle( int prletterId ) {
		
		return prletterDao.queryAnswerByPrletterTitle( prletterId );
		
	}
	
	public static boolean addQuestionOrAnswer( Prletter prletter ) {
		
		return prletterDao.addQuestionOrAnswer( prletter );
		
	}
	
	public static boolean removePrletter( int prletterId , String email ) {
		
		String removeInfo = prletterDao.queryRemove( prletterId );
		
		String[] str = removeInfo.split("-");
		
		for( int i = 0 ; i < str.length ; i ++ ) {
			
			if( str[i].equals( email ) ) {
				
				str[i+1] = 1+"";
				
			}
			
		}
		
		removeInfo = str[0]+"-"+str[1]+"-"+str[2]+"-"+str[3];
		
		return prletterDao.removePrletter( prletterId , removeInfo );
		
		
	}
	
	public static boolean flagRead( int prletterId ) {
		
		return prletterDao.flagRead( prletterId );
		
	}
	
	public static boolean flagAnswer( int oldPrletterId , int newPrletterId ) {
		
		return prletterDao.flagAnswer( oldPrletterId , newPrletterId );
		
	}
	
	public static String queryEmailByPrletterId( int prletterId ) {
		
		return prletterDao.queryEmailByPrletterId( prletterId );
		
	}
	
}
