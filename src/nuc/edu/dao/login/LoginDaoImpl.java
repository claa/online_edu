package nuc.edu.dao.login;

import java.sql.ResultSet;

/**
 * ʵ�ֵ�¼�����Ľӿ�
 * @author TaoXu
 *
 */
public interface LoginDaoImpl {
      public ResultSet find(String no , String pass ,String type); //�����û��Ƿ���� (���룬����,����)
      public ResultSet getPass(String no , String name , String type,String email);//�һ�����(����,����,���ͣ�����)
}
