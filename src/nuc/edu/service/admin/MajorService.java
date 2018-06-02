package nuc.edu.service.admin;

import java.util.List;

import nuc.edu.dao.admin.MajorDao;
import nuc.edu.entity.Major;

/**
 * 返回专业名和专业id
 * @author TaoXu
 *
 */
public class MajorService {
      MajorDao mdao = new MajorDao();
      //返回专业id
      public Major findById(String obj){
    	  return mdao.findById(obj);
      }
      //返回专业名称      
      public Major findByName(int id) {
    	  return mdao.findByName(id);
      }
      
      public int Insert(Major obj) {
    	  return mdao.Insert(obj);
      }
      
      public int Delete(Major obj) {
    	  return mdao.Delete(obj);
      }
      
      public List<Major> findAll(int start){
    	  return mdao.findAll(start);
      }
      
      //通过id 查找
      public Major findById(Major obj) {
    	  return mdao.findById(obj);
      }
      
      public int Updates(Major obj) {
    	  return mdao.Updates(obj);
      }
}
