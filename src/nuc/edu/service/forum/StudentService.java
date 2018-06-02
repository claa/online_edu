package nuc.edu.service.forum;

import nuc.edu.dao.forum.StudentDao;
import nuc.edu.dao.forum.StudentDaoImpl;
import nuc.edu.entity.Student;

public class StudentService {
	  StudentDao studentdao=new StudentDaoImpl();
	public Student selectStudentById(int s_id) {
		return  studentdao.selectStudentById(s_id);
	}
}
