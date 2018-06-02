package nuc.edu.dao.login;

import java.sql.ResultSet;

/**
 * 实现登录方法的接口
 * @author TaoXu
 *
 */
public interface LoginDaoImpl {
      public ResultSet find(String no , String pass ,String type); //检测该用户是否存在 (号码，密码,类型)
      public ResultSet getPass(String no , String name , String type,String email);//找回密码(号码,名字,类型，邮箱)
}
