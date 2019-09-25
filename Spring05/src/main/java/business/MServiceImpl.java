package business;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import vo.MemberVO;

// Service Ŭ������ ����
// => Controller �� ��û�� ���� DAO �� �ش� �޼��带 ����
// => �׷��Ƿ� DAO �� ��� ����� ó���ϴ� �޼��� ����
// => Shift+Art+T : interface �ڵ����� ����޴�

@Service("member")
public class MServiceImpl implements MService {
	@Inject //java ���� ���� ,@Autowired�� �������� ����
	private SqlSession dao ; //dao�� �ƴ϶� sqlsessionfactory�� ���
	
	
	
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
