package nuc.edu.dao.prletter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nuc.edu.conn.Conn;
import nuc.edu.entity.Prletter;
import nuc.edu.entity.Teacher;
import nuc.edu.util.PrletterIsShow;

public class PrletterDaoImpl implements PrletterDao {

	String queryEmailBySno = "select s_Email from student where s_no=?";
	String queryEmailByTno = "select t_Email from teacher where t_no=?";
	String querySendInfo = "select * from prletter where sender_Email=?";
	String queryReceiveInfo = "select * from prletter where receiver_Email=?";
	String queryTeacherInfo = "select * from teacher where t_major=?";
	String queryEmailByCourseId = "select t_Email from teacher where course_id=?";
	String queryAnswerByTitle = "select * from prletter where prletter_title=?";
	String addQuestionOrAnswer = "insert into prletter(prletter_content,sender_Email,receiver_Email,prletter_time,prletter_read,prletter_title,prletter_remove) values(?,?,?,?,?,?,?)";
	String modifyRead = "update prletter set prletter_read=? where prletter_id=?";
	String modifyAnswer = "update prletter set prletter_title=? where prletter_id=?";
	String queryReceiveEmail = "select sender_Email from prletter where prletter_id=?";
	String removePrletter = "update prletter set prletter_remove=? where prletter_id=?";
	String queryRemove = "select prletter_remove from prletter where prletter_id=?";
	
	Connection conn = Conn.getConn();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public String queryStudentEmailBySno(String sno) {

		String studentEmail = null;
		
        try {
        	
        	pst = conn.prepareStatement( queryEmailBySno );
        	pst.setString( 1 , sno );
        	
        	rs = pst.executeQuery();
        	
        	if( rs.next() ) {
        		
        		studentEmail = rs.getString("s_Email");
        		
        	}
        	
        } catch( Exception e ) {
        	
        	e.printStackTrace();
        	
        }
		
		return studentEmail;
		
		
	}

	public String queryTeacherEmailByTno(String tno) {

        String teacherEmail = null;
        
        try {
        	
        	pst = conn.prepareStatement( queryEmailByTno );
        	pst.setString( 1 , tno );
        
        	rs = pst.executeQuery();
        	
        	if( rs.next() ) {
        		
        		teacherEmail = rs.getString("t_Email");
        		
        	}
        	
        } catch( Exception e ) {
        	
        	e.printStackTrace();
        	
        }
		
		return teacherEmail;
		
		
	}

	public List<Prletter> querySendInfo(String senderEmail) {
		
		List<Prletter> list = new ArrayList<Prletter>();
		
		try {
			
			pst = conn.prepareStatement( querySendInfo );
			pst.setString( 1 , senderEmail );
			
			rs = pst.executeQuery();
			
			while( rs.next() ) {
				
				Prletter prletter = new Prletter();
				
				prletter.setPrletter_id( rs.getInt("prletter_id") );
				prletter.setPrletter_content( rs.getString("prletter_content") );
				prletter.setSender_Email( rs.getString("sender_Email") );
				prletter.setReceiver_Email( rs.getString("receiver_Email") );
				prletter.setPrletter_time( rs.getString("prletter_time") );
				
				if( PrletterIsShow.prletterIsShow( senderEmail , rs.getString("prletter_remove") ) ) {
					
					list.add( prletter );
					
				}
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return list;
		
		
	}

	public List<Prletter> queryReceiveInfo(String receiveEmail) {

		List<Prletter> list = new ArrayList<Prletter>();
	
		try {
			
			pst = conn.prepareStatement( queryReceiveInfo );
			pst.setString( 1 , receiveEmail );
			
			rs = pst.executeQuery();
			
			while( rs.next() ) {
				
				Prletter prletter = new Prletter();
				
				prletter.setPrletter_id( rs.getInt("prletter_id") );
				prletter.setPrletter_content( rs.getString("prletter_content") );
				prletter.setSender_Email( rs.getString("sender_Email") );
				prletter.setReceiver_Email( rs.getString("receiver_Email") );
				prletter.setPrletter_time( rs.getString("prletter_time") );
				prletter.setPrletter_read( rs.getInt("prletter_read") );
				
				if( PrletterIsShow.prletterIsShow( receiveEmail , rs.getString("prletter_remove") ) ) {
				
					list.add( prletter );
				
				}
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return list;
		
		
	}

	public List<Teacher> queryTeacherInfoByMajorId(int majorId) {

        List<Teacher> list = new ArrayList<Teacher>();
        
        try {
        	
        	pst = conn.prepareStatement( queryTeacherInfo );
        	pst.setInt( 1 , majorId );
        	
        	rs = pst.executeQuery();
        	
        	while( rs.next() ) {
        		
        		Teacher teacher = new Teacher();
        		teacher.setT_id(rs.getInt("t_id"));
        		teacher.setT_username( rs.getString("t_username") );
        		teacher.setT_no(rs.getString("t_no"));
        		teacher.setT_introduce( rs.getString("t_introduce") );
        		teacher.setT_Email( rs.getString("t_Email") );
        		teacher.setT_major( rs.getInt("t_major") );
        		teacher.setCourse_id( rs.getInt("course_id") );
        		
        		list.add( teacher );
        		
        	}
        	
        } catch( Exception e ) {
        	
        	e.printStackTrace();
        	
        }
		
		return list;
		
		
	}

	public String queryEmailByCourseId(int courseId) {

		String teacherEmail = null;
		
		try {
			
			pst = conn.prepareStatement( queryEmailByCourseId );
			pst.setInt( 1 , courseId );
			
			rs = pst.executeQuery();
			
			if( rs.next() ) {
				
				teacherEmail = rs.getString("t_Email");
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return teacherEmail;
		
		
	}

	public List<Prletter> queryAnswerByPrletterTitle(int prletterId) {

		List<Prletter> list = new ArrayList<Prletter>();
		
		try {
			
			pst = conn.prepareStatement( queryAnswerByTitle );
			pst.setInt( 1 , prletterId );
			
			rs = pst.executeQuery();
			
			while( rs.next() ) {
				
				Prletter prletter = new Prletter();
				
				prletter.setPrletter_id( rs.getInt("prletter_id") );
				prletter.setPrletter_content( rs.getString("prletter_content") );
				prletter.setSender_Email( rs.getString("sender_Email") );
				prletter.setReceiver_Email( rs.getString("receiver_Email") );
				prletter.setPrletter_time( rs.getString("prletter_time") );
				
				if( PrletterIsShow.prletterIsShow( prletter.getReceiver_Email() , rs.getString("prletter_remove") ) ) {
				
					list.add( prletter );
				
				}
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return list;
		
		
	}

	public boolean addQuestionOrAnswer(Prletter prletter) {

		boolean flag = false;
		
		try {
			
			pst = conn.prepareStatement( addQuestionOrAnswer );
			
			pst.setString( 1 , prletter.getPrletter_content() );
			pst.setString( 2 , prletter.getSender_Email() );
			pst.setString( 3 , prletter.getReceiver_Email() );
			pst.setString( 4 , prletter.getPrletter_time() );
			pst.setInt( 5 , 0 );
			pst.setInt( 6 , prletter.getPrletter_title() );
			pst.setString( 7 , prletter.getSender_Email()+"-"+0+"-"+prletter.getReceiver_Email()+"-"+0 );
			
			if( pst.executeUpdate() > 0 ) {
				
				flag = true;
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return flag;
		
		
	}
	
	public boolean flagRead(int prletterId) {

		boolean flag = false;
		
		try {
			
			pst = conn.prepareStatement( modifyRead );
			pst.setInt( 1 , 1 );
			pst.setInt( 2 , prletterId );
			
			if( pst.executeUpdate() > 0 ) {
				
				flag = true;
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return flag;
		
		
	}

	public boolean flagAnswer(int oldPrletterId, int newPrletterId) {

		boolean flag = false;
		
		try {
			
			pst = conn.prepareStatement( modifyAnswer );
			pst.setInt( 1 , oldPrletterId );
			pst.setInt( 2 , newPrletterId );
			
			if( pst.executeUpdate() > 0 ) {
				
				flag = true;
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return flag;
		
		
	}

	public String queryEmailByPrletterId(int prletterId) {

        String senderEmail = null;
		
        try {
        	
        	pst = conn.prepareStatement( queryReceiveEmail );
        	pst.setInt( 1 , prletterId );
        	
        	rs = pst.executeQuery();
        	
        	if( rs.next() ) {
        		
        		senderEmail = rs.getString( "sender_Email" );
        		
        	}
        	
        } catch( Exception e ) {
        	
        	e.printStackTrace();
        	
        }
        
		return senderEmail;
		
		
	}

	public boolean removePrletter(int prletterId, String remove) {

		boolean flag = false;
		
		try {
			
			pst = conn.prepareStatement( removePrletter );
			pst.setString( 1 , remove );
			pst.setInt( 2 , prletterId );
			
			if( pst.executeUpdate() > 0 ) {
				
				flag = true;
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return flag;
		
		
	}

	public String queryRemove(int prletterId) {

		String removeInfo = null;
		
		try {
			
			pst = conn.prepareStatement( queryRemove );
			pst.setInt( 1 , prletterId );
			
			rs = pst.executeQuery();
			
			if( rs.next() ) {
				
				removeInfo = rs.getString("prletter_remove");
				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		return removeInfo;
		
		
	}

	
}
