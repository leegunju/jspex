package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int edit(BoardVO bvo);

	int delete(int bno);

	int updateCount(int bno);

	int totCount(PagingVO pgvo);

	List<BoardVO> pageList(PagingVO pgvo);

	String selectRemove(int bno);

}
