package nuc.edu.service.admin;

import java.util.List;

import nuc.edu.dao.admin.StudentDao;
import nuc.edu.entity.Student;

public class StudentService {
   StudentDao sdao =new StudentDao();
   
   public List<Student> findAll(int start){
	   return sdao.findAll(start);
   }
}
