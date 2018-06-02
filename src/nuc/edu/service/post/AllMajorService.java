package nuc.edu.service.post;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.dao.post.AllMajorDao;
import nuc.edu.dao.post.AllMajorDaoImpl;
import nuc.edu.entity.Major;

public class AllMajorService {

	private AllMajorDao allMajorDao = new AllMajorDaoImpl();
	public List<Major> selectAllMajor(int academy_id){
		List<Major> majors = new ArrayList<Major>();
		majors = allMajorDao.selectAllMajor(academy_id);
		return majors;
	}
}
