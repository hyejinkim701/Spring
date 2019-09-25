package business;

import java.util.ArrayList;

import vo.BoardVO;
import vo.PageVO;

public interface BService {
	
	PageVO pageList(PageVO pvo); //pageList
	
	ArrayList<BoardVO> selectList();//selectList

	BoardVO selectOne(BoardVO vo);//selectOne

	int insert(BoardVO vo);//selectOne

	int update(BoardVO vo);//selectOne

	int delete(BoardVO vo);//selectOne
	
	int countUp(BoardVO vo); // countUp
	
	int rinsert(BoardVO vo); // reply insert
}//interface