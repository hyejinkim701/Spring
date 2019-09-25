package business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.BoardDAO;
import vo.BoardVO;
import vo.PageVO;

@Service
public class BServiceImpl implements BService {
	@Autowired
	private BoardDAO dao;
	
	
	public PageVO pageList(PageVO pvo) {
		return dao.pageList(pvo);
	}
	
	@Override
	public ArrayList<BoardVO> selectList() {
		return dao.boardList();
	}//selectList
	

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return dao.boardDetail(vo);
	}//selectOne
	
	
	@Override
	public int insert(BoardVO vo) {
		return dao.boardInsert(vo);
	}// insert
	
	@Override
	public int update(BoardVO vo) {
		return dao.boardUpdate(vo);
	}//update

	@Override
	public int delete(BoardVO vo) {
		return dao.boardDelete(vo);
	}//delete
	

	@Override
	public int countUp(BoardVO vo) {
		return dao.countUp(vo);
	}//countUp
	
	@Override
	public int rinsert(BoardVO vo) {
		return dao.rinsert(vo);
	}//rinsert
	
	
}
