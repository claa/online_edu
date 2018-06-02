package nuc.edu.dao.post;

import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public interface LoginDao {
	//学生登录
	public Student StudentLogin(Student student);
	//教师登录
	public Teacher teacherLogin(Teacher teacher);
}
