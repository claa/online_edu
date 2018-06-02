package nuc.edu.action.prletter;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QueryReceiveInfo extends ActionSupport {

	private List<Prletter> receiveInfoList = new ArrayList<Prletter>();
	
	public List<Prletter> getReceiveInfoList() {
		return receiveInfoList;
	}

	public void setReceiveInfoList(List<Prletter> receiveInfoList) {
		this.receiveInfoList = receiveInfoList;
	}

	public String studentExecute() {
		
		String sno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.queryReceiveInfo( PrletterService.queryStudentEmailBySno( sno ) ).size() != 0 ) {
			
			receiveInfoList = PrletterService.queryReceiveInfo( PrletterService.queryStudentEmailBySno( sno ) );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public String teacherExecute() {
		
		String tno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.queryReceiveInfo( PrletterService.queryTeacherEmailByTno( tno ) ).size() != 0 ) {
			
			receiveInfoList = PrletterService.queryReceiveInfo( PrletterService.queryTeacherEmailByTno( tno ) );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	
}
