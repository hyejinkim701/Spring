package business;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import vo.MemberVO;

// Service 클래스의 역할
// => Controller 의 요청에 따라 DAO 의 해당 메서드를 실행
// => 그러므로 DAO 의 모든 기능을 처리하는 메서드 구현
// => Shift+Art+T : interface 자동생성 단축메뉴

@Service("member")
public class MServiceImpl implements MService {
	@Inject //java 에서 제공 ,@Autowired는 스프링이 제공
	private SqlSession dao ; //dao가 아니라 sqlsessionfactory를 사용
	
	
	
	private static final String NS="green.mapper.MemberMapper."; //name space
	
	 
	 @Override 
	 public ArrayList<MemberVO> selectList() { 
		 return (ArrayList)dao.selectList(NS+"memberlist");
		 }
	 
	
	  @Override
	  public MemberVO selectOne(MemberVO vo) {
		 return dao.selectOne(NS+"selectDetail",vo); 
	  }
	  
	  @Override
	  public MemberVO loginCheck(MemberVO vo)  {
		  return dao.selectOne(NS+"loginMember",vo); 
	
	  }
	  
	  @Override
	  public int insert(MemberVO vo) {
	  return dao.insert(NS+"insertMember",vo); 
	  }
	  
	  @Override
	  public int update(MemberVO vo) {
	   return dao.update(NS+"updateMember",vo);
	   }
	  
	  @Override
	  public int delete(MemberVO vo) {
	   return dao.delete(NS+"deleteMember",vo);
	   }
	 
	
	
} // class
