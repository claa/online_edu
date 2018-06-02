package nuc.edu.service.post;

import nuc.edu.dao.post.LoginDao;
import nuc.edu.dao.post.LoginDaoImpl;
import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public class LoginService {

	public LoginDao loginDao = new LoginDaoImpl();
	
	//实现学生登录
	public Student studentLogin(Student student){
		return loginDao.StudentLogin(student);
	}
	//实现老师登录
	public Teacher teacherLogin(Teacher teacher){
		return loginDao.teacherLogin(teacher);
	}
}















