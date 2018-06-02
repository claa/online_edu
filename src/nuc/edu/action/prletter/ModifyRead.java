package nuc.edu.action.prletter;

import nuc.edu.entity.Prletter;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ModifyRead extends ActionSupport implements ModelDriven<Prletter> {

	private Prletter prletter = new Prletter();
	
	public String execute() {
		
		if( PrletterService.flagRead( prletter.getPrletter_id() ) ) {
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
	}
	
	public Prletter getModel() {
		// TODO Auto-generated method stub
		return prletter;
	}
	
	
}
