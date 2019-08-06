package kr.green.test.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.test.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> getBoardList(Criteria cri, String valid);

	public int getTotalCount(Criteria cri, String valid);

	public void registerBoard(BoardVO bVo);

	public BoardVO getBoard(Integer num);
}
