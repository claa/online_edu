package nuc.edu.action.prletter;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;
import nuc.edu.util.LocaleTimeUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddQuestionOrAnswer extends ActionSupport implements ModelDriven<Prletter> {

	private Prletter prletter = new Prletter();
	private int courseId;
	private int prletterId;

	public int getPrletterId() {
		return prletterId;
	}

	public void setPrletterId(int prletterId) {
		this.prletterId = prletterId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String studentExecute() {
		
		String sno = (String) ActionContext.getContext().getSession().get( "sno" );
		System.out.println(sno);
		prletter.setPrletter_time( LocaleTimeUtil.getLocaleTime() );
		prletter.setSender_Email( PrletterService.queryStudentEmailBySno( sno ) );
		
		if( courseId != 0 ) {
			prletter.setReceiver_Email( PrletterService.queryEmailByCourseId( courseId ) );
		}
		else if( prletterId != 0 ) {
			prletter.setReceiver_Email( PrletterService.queryEmailByPrletterId( prletterId ) );
			prletter.setPrletter_title( prletterId );
		}
		
		if( PrletterService.addQuestionOrAnswer( prletter ) ) {
			
			if( prletterId != 0 ) {
				
				PrletterService.flagRead( prletterId );
				
			}
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public String teacherExecute() {
		
		String tno = (String) ActionContext.getContext().getSession().get( "sno" );
		
		prletter.setPrletter_time(LocaleTimeUtil.getLocaleTime() );
		prletter.setSender_Email( PrletterService.queryTeacherEmailByTno( tno ) );
		prletter.setReceiver_Email( PrletterService.queryEmailByPrletterId( prletterId ) );
		prletter.setPrletter_title( prletterId );
		
		if( PrletterService.addQuestionOrAnswer( prletter ) ) {
			
			PrletterService.flagRead( prletterId );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}

	public Prletter getModel() {
		// TODO Auto-generated method stub
		return prletter;
	}
	
	
}
