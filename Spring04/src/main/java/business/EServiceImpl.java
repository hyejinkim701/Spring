package business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.EmpDAO;
import vo.EmpVO;

@Service("employee")
public class EServiceImpl implements EService {
	@Autowired
	private EmpDAO dao ;
	
	@Override
	public ArrayList<EmpVO> selectList() {
		return dao.employeeList();
	}
	@Override
	public EmpVO selectOne(EmpVO vo) {
		return dao.eDetail(vo);
	}

	@Override
	public int insert(EmpVO vo) {
		return dao.eInsert(vo);
	}
	@Override
	public int update(EmpVO vo) {
		return dao.eUpdate(vo);
	}
	@Override
	public int delete(EmpVO vo) {
		return dao.eDelete(vo);
	}
} // class