package nuc.edu.service.forum;

import nuc.edu.dao.forum.TeacherDao;
import nuc.edu.dao.forum.TeacherDaoImpl;
import nuc.edu.entity.Teacher;

public class TeacherService {
	 TeacherDao teacherdao=new TeacherDaoImpl();
	public Teacher selectTeacherById(int t_id) {
		     return teacherdao.selectTeacherById(t_id);
	}
}
