package nuc.edu.dao.admin;

import java.util.List;

/**
 * 实现管理员的接口方法
 * @author TaoXu
 *
 */
public interface AdminDaoImpl<T> {
      public int Insert(T obj); //插入帖子 
      public int Delete(T obj);   //删除
      public List<T> findAll(int start);  //查询所有帖子，分页显示
      public T findById(T obj); //查询一个帖子
      public T Update(T obj);//实现置顶，修改sign
      public List<T> findOrder(); //倒序查询所有帖子，只显示5条
      public List<T> findTopPost(); //查询所有置顶帖
      
      
      
      
}
