package nuc.edu.action.prletter;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class QueryAnswer extends ActionSupport implements ModelDriven<Prletter> {

	private Prletter prletter = new Prletter();
	private List<Prletter> answerList = new ArrayList<Prletter>();

	public List<Prletter> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Prletter> answerList) {
		this.answerList = answerList;
	}

	public String execute() {
		
		if( PrletterService.queryAnswerByPrletterTitle( prletter.getPrletter_id() ).size() != 0 ) {
			
			answerList = PrletterService.queryAnswerByPrletterTitle( prletter.getPrletter_id() );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public Prletter getModel() {
		// TODO Auto-generated method stub
		return prletter;
	}
	

}
