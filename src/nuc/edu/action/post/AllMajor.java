package nuc.edu.action.post;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.entity.Major;
import nuc.edu.service.post.AllMajorService;

import com.opensymphony.xwork2.ActionSupport;

public class AllMajor extends ActionSupport {

	private AllMajorService allMajorService = new AllMajorService();
	private int academy_id;
	private List<Major> majorsList = new ArrayList<Major>();
	public List<Major> getMajorsList() {
		return majorsList;
	}
	public void setMajorsList(List<Major> majorsList) {
		this.majorsList = majorsList;
	}
	public int getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(int academy_id) {
		this.academy_id = academy_id;
	}
	
	public String selectAllMajorMethod(){
		majorsList = allMajorService.selectAllMajor(academy_id);
		return "selectAllMajorOK";
	}
	
}






