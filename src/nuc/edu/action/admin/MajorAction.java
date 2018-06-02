package nuc.edu.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Major;
import nuc.edu.service.admin.MajorService;

public class MajorAction extends ActionSupport implements ModelDriven<Major> {
    private Major major = new Major();
    List<Major> majors = new ArrayList<Major>();
    private Major majored;
    MajorService mser = new MajorService();
    int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public Major getMajored() {
		return majored;
	}

	public void setMajored(Major majored) {
		this.majored = majored;
	}
    
	public String InsertMajor() {
		int a = mser.Insert(major);
		if(a != 0) {
			return "insertOk";
		}else {
			return ERROR;
		}
	}
	public String DeleteMajor() {
		int a = mser.Delete(major);
		if(a != 0) {
			return "deleteOk";
		}else {
			return ERROR;
		}
	}
	
	public String findAllMajor() {
		if(id == 0){
		majors = mser.findAll(1);
		}else{
		majors = mser.findAll(id);
		}
		return "findAllOk";
	}
	
	public String findById() {
		majored = mser.findById(major);
		return "findOk";
	}
	
	public String UpdateMajor() {
		int a = mser.Updates(major);
		if(a != 0) {
			return "updateOk";
		}else {
			return ERROR;
		}
	}
	public Major getModel() {
		// TODO Auto-generated method stub
		return major;
	}

}
