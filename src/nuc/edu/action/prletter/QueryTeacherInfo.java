package nuc.edu.action.prletter;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.entity.Teacher;
import nuc.edu.service.prletter.PrletterService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QueryTeacherInfo extends ActionSupport {

	private int majorId;
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	
	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public String execute() {
		
		if( PrletterService.queryTeacherInfoByMajorId( majorId ).size() != 0 ) {
			
			teacherList = PrletterService.queryTeacherInfoByMajorId( majorId );
			
			return SUCCESS;
			
		}
		
		return INPUT;
		
		
	}
	

}
