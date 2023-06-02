package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>> insert dao 집입~!!");
		int isOk = sql.insert(NS+"reg", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info(">>> selectList dao 집입~!!");
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info(">>> selectOne dao 집입~!!");
		return sql.selectOne(NS+"one", bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		log.info(">>> edit DAO 진입");
		int isOk = sql.update(NS+"mod", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info(">>> delete DAO 진입");
		int isOk = sql.delete(NS+"del", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int updateCount(int bno) {
		// TODO Auto-generated method stub
		int isOk = sql.update(NS+"count", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int totCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"cnt", pgvo);
	}

	@Override
	public List<BoardVO> pageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		//return sql.selectList(NS+"pageList", pgvo);
		return sql.selectList(NS+"selectList", pgvo);
	}

	@Override
	public String selectRemove(int bno) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"removeFile", bno);
	}

}
