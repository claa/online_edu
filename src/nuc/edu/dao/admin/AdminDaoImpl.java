package nuc.edu.dao.admin;

import java.util.List;

/**
 * ʵ�ֹ���Ա�Ľӿڷ���
 * @author TaoXu
 *
 */
public interface AdminDaoImpl<T> {
      public int Insert(T obj); //�������� 
      public int Delete(T obj);   //ɾ��
      public List<T> findAll(int start);  //��ѯ�������ӣ���ҳ��ʾ
      public T findById(T obj); //��ѯһ������
      public T Update(T obj);//ʵ���ö����޸�sign
      public List<T> findOrder(); //�����ѯ�������ӣ�ֻ��ʾ5��
      public List<T> findTopPost(); //��ѯ�����ö���
      
      
      
      
}
