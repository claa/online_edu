package nuc.edu.service.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import nuc.edu.dao.login.LoginDao;
/**
 * ʵ�ּ����¼���һ��������ֹ���
 * @author Administrator
 *
 */
public class LoginService {
      private LoginDao ldao =new LoginDao();
      ResultSet rst=null;
      public ResultSet find(String no , String pass ,String type) {
    	  rst = ldao.find(no, pass, type);
          return rst;
      }
      public ResultSet getPass(String no , String name , String type,String email) {
    	  rst =ldao.getPass(no, name, type, email);
    	  return rst;
      }
}
