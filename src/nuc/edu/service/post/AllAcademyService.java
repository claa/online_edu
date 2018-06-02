package nuc.edu.service.post;

import java.util.ArrayList;
import java.util.List;

import nuc.edu.dao.post.AllAcademyDao;
import nuc.edu.dao.post.AllAcademyDaoImpl;
import nuc.edu.entity.Academy;

public class AllAcademyService {
	
	private AllAcademyDao academyDao = new AllAcademyDaoImpl();
	public List<Academy> selectAllAcademy(){
		List<Academy> academys = new ArrayList<Academy>();
		academys = academyDao.selectAllAcademy();
		return academys;
	}
	
}
