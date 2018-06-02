package nuc.edu.action.post;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.entity.Academy;
import nuc.edu.service.post.AllAcademyService;

import com.opensymphony.xwork2.ActionSupport;

public class AllAcademy extends ActionSupport {

	private List<Academy> academyList = new ArrayList<Academy>();
	private AllAcademyService academyService = new AllAcademyService();
	public List<Academy> getAcademyList() {
		return academyList;
	}
	public void setAcademyList(List<Academy> academyList) {
		this.academyList = academyList;
	}


	public String selectAllAcademyMethod(){
		academyList = academyService.selectAllAcademy();
		return "selectAllOK";
	}
}
