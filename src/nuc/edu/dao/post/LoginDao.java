package nuc.edu.dao.post;

import nuc.edu.entity.Student;
import nuc.edu.entity.Teacher;

public interface LoginDao {
	//ѧ����¼
	public Student StudentLogin(Student student);
	//��ʦ��¼
	public Teacher teacherLogin(Teacher teacher);
}
