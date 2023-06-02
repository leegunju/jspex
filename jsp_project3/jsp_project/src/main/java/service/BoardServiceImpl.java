package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info(">>> register service 집입~!!");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> list() {
		log.info(">>> list service 집입~!!");
		return bdao.selectList();
	}

	@Override
	public BoardVO detail(int bno) {
		log.info(">>> detail service 집입~!!");
		// read_count update 요청 후 detail값을 요청
		int isOk = bdao.updateCount(bno);
		try {
			Thread.sleep(500); //0.5초 후에 selectOne() 요청
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (isOk > 0)? bdao.selectOne(bno) : null;
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info(">>> modify service 집입~!!");
		return bdao.edit(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info(">>> remove service 집입~!!");
		return bdao.delete(bno);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.totCount(pgvo);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.pageList(pgvo);
	}

	@Override
	public String getFileName(int bno) {
		// TODO Auto-generated method stub
		return bdao.selectRemove(bno);
	}

}
