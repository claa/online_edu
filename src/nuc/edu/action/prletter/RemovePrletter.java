package nuc.edu.action.prletter;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class RemovePrletter extends ActionSupport implements ModelDriven<Prletter> {

	private Prletter prletter = new Prletter();
	
	public String studentExecute() {
		
		String sno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.removePrletter( prletter.getPrletter_id() , PrletterService.queryStudentEmailBySno( sno ) ) ) {
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public String teacherExecute() {
		
		String tno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.removePrletter( prletter.getPrletter_id() , PrletterService.queryTeacherEmailByTno( tno ) ) ) {
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public Prletter getModel() {
		// TODO Auto-generated method stub
		return prletter;
	}

	
	
}
