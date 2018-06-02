package nuc.edu.dao.post;

import java.util.List;

import nuc.edu.entity.Major;

public interface AllMajorDao {

	public List<Major> selectAllMajor(int academy_id);
}
