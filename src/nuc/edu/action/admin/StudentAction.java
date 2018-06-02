/**
 * 
 */
package nuc.edu.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.edu.entity.Student;
import nuc.edu.service.admin.StudentService;

/**
 * @author Administrator
 *
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student student =new Student();
    StudentService ser = new StudentService();
    List<Student> students = new ArrayList<Student>();
    int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
    
	public String findAllStudent() {
		if(id == 0){
		students = ser.findAll(1);
		}else{
			students = ser.findAll(id);
		}

		return "findAllOk";
	}
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}

}
