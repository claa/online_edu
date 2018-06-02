package nuc.edu.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Major;
import nuc.edu.entity.Teacher;
import nuc.edu.service.admin.MajorService;
import nuc.edu.service.admin.TeacherService;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher> {
    private Teacher teacher = new Teacher();
    List<Teacher> teachers = new ArrayList<Teacher>();
    private Teacher teachered;
    private Major majored;
    TeacherService tser =new TeacherService();
    MajorService mser = new MajorService();
    String major_name ;
    int id;
    
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor_name() {
		return major_name;
	}

	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher getTeachered() {
		return teachered;
	}

	public void setTeachered(Teacher teachered) {
		this.teachered = teachered;
	}

	public Major getMajored() {
		return majored;
	}

	public void setMajored(Major majored) {
		this.majored = majored;
	}
    
	public String InsertTeacher() {
		Major  m = mser.findById(major_name);//找到专业id
		int a =tser.Insert(teacher, m);
		if(a != 0) {
			return "insertOk";
		}else {
			return ERROR;
		}
	}
	
	public String DeleteTeacher() {
		int a = tser.Delete(teacher);
		if(a != 0) {
			return "deleteOk";
		}else {
			return ERROR;
		}
	}
	
	public String findAllTeacher() {
		if(id == 0){
		teachers = tser.findAll(1);
		}else{
			teachers = tser.findAll(id);
		}
		return "findAllOk";
	}
	
	public String findById() {
		Teacher t = tser.findById(teacher);
		teachered = tser.findById(teacher);
		majored = mser.findByName(t.getT_major());
		return "findOk";
	}
	public String UpdateTeacher() {
		 Major m = mser.findById(major_name);
	    int a= tser.Update(teacher, m);
	     if(a != 0) {
		 return "updateOk";
	    }else {
	    	return ERROR;
	    }
		
	}
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

}
