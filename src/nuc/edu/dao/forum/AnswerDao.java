package nuc.edu.dao.forum;

import java.util.List;

import nuc.edu.entity.Answer;

public interface AnswerDao {
	public int addAnswer(Answer answer);
	public List<Answer> selectAnswer(int forum_id);
	public int CountAnswer();
	public int addAnswer_Like_id(int answer_id,String new_like_id);
	public Answer selectAnswerForLikeId(int answer_id);
}
