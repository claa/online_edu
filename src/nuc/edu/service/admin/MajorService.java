package nuc.edu.service.admin;

import java.util.List;

import nuc.edu.dao.admin.MajorDao;
import nuc.edu.entity.Major;

/**
 * ����רҵ����רҵid
 * @author TaoXu
 *
 */
public class MajorService {
      MajorDao mdao = new MajorDao();
      //����רҵid
      public Major findById(String obj){
    	  return mdao.findById(obj);
      }
      //����רҵ����      
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
      
      //ͨ��id ����
      public Major findById(Major obj) {
    	  return mdao.findById(obj);
      }
      
      public int Updates(Major obj) {
    	  return mdao.Updates(obj);
      }
}
