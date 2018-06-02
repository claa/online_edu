package nuc.edu.dao.prletter;

import java.util.List;

import nuc.edu.entity.Prletter;

public interface PrletterDao {

	public String queryStudentEmailBySno( String sno );
	
	public String queryTeacherEmailByTno( String tno );
	
	public List<?> querySendInfo( String senderEmail );
	
	public List<?> queryReceiveInfo( String receiveEmail );
	
	public List<?> queryTeacherInfoByMajorId( int majorId );
	
	public String queryEmailByCourseId( int courseId );
	
	public String queryEmailByPrletterId( int prletterId );
	
	public List<?> queryAnswerByPrletterTitle( int prletterId );
	
	public String queryRemove( int prletterId );
	
	public boolean addQuestionOrAnswer( Prletter prletter );
	
	public boolean removePrletter( int prletterId , String remove );
	
	public boolean flagRead( int prletterId );
	
	public boolean flagAnswer( int oldPrletterId , int newPrletterId );
	
	
}
