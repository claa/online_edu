package nuc.edu.service.admin;

import java.util.List;

import nuc.edu.dao.admin.TeacherDao;
import nuc.edu.entity.Major;
import nuc.edu.entity.Teacher;

public class TeacherService {
       TeacherDao tdao = new TeacherDao();
       public int Insert(Teacher obj ,Major obj2) {
    	   return tdao.Insert(obj, obj2);
       }
       
       public int Delete(Teacher obj) {
    	   return tdao.Delete(obj);
       }
       
       public List<Teacher> findAll(int start){
    	   return tdao.findAll(start);
       }
       
       public Teacher findById(Teacher obj) {
    	   return tdao.findById(obj);
       }
       
       public int Update(Teacher obj,Major obj2) {
    	   return tdao.Update(obj, obj2);
       }
}
