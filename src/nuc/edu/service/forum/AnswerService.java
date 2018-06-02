package nuc.edu.service.forum;

import java.util.List;

import nuc.edu.dao.forum.AnswerDao;
import nuc.edu.dao.forum.AnswerDaoImpl;
import nuc.edu.entity.Answer;

public class AnswerService {
	AnswerDao answerdao=new AnswerDaoImpl();
	public int addAnswer(Answer answer) {
 		return answerdao.addAnswer(answer);
 	}
	public List<Answer> selectAnswer(int forum_id) {
		return answerdao.selectAnswer(forum_id);
	}
	public int CountAnswer() {
		  return answerdao.CountAnswer();
	}
	public int addAnswer_Like_id(int answer_id,String new_like_id) {
		return answerdao.addAnswer_Like_id(answer_id, new_like_id);
	}
	public Answer selectAnswerForLikeId(int answer_id) {
		return answerdao.selectAnswerForLikeId(answer_id);
	}
}
