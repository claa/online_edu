package nuc.edu.action.prletter;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;

@SuppressWarnings("serial")
public class QuerySendInfo extends ActionSupport {

	private List<Prletter> sendInfoList = new ArrayList<Prletter>();
	
	public List<Prletter> getSendInfoList() {
		return sendInfoList;
	}

	public void setSendInfoList(List<Prletter> sendInfoList) {
		this.sendInfoList = sendInfoList;
	}

	public String studentExecute() {
		
		String sno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.querySendInfo( PrletterService.queryStudentEmailBySno( sno ) ).size() != 0 ) {
			
			sendInfoList = PrletterService.querySendInfo( PrletterService.queryStudentEmailBySno(sno) );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public String teacherExecute() {
		
		String tno = (String) ActionContext.getContext().getSession().get("sno");
		
		if( PrletterService.querySendInfo( PrletterService.queryTeacherEmailByTno( tno ) ).size() != 0 ) {
			
			sendInfoList = PrletterService.querySendInfo( PrletterService.queryTeacherEmailByTno( tno ) );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
}
