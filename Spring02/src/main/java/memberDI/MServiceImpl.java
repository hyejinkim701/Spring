package memberDI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.MemberDAO;
import vo.MemberVO;

@Component("mm")
public class MServiceImpl implements MService {
	//@Autowired
	//변수에 적용하면 기본 생성자를 사용하므로 반드시 기본생성자가 있어야함
	MemberDAO dao;
	
	//public MServiceImpl() {	} //디폴트생성자를 만들어줌
	
	// Test1. 생성자를 통한 주입
	@Autowired
	public MServiceImpl(MemberDAO dao) {
		this.dao=dao;
	}
	
	//MemberList
	public ArrayList<MemberVO> selectList(){
		return dao.memberList();
	}
	//login
	public MemberVO loginCheck(MemberVO vo) {
		return dao.memberLogin(vo);
	}
	//detail
	public MemberVO selectOne(MemberVO vo) {
		return dao.mDetail(vo);
	}

}//class
