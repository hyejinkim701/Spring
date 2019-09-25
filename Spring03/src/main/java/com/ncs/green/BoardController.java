package com.ncs.green;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.BService;
import vo.BoardVO;
import vo.PageVO;

@Controller
public class BoardController {
	@Autowired
	private BService service;

	// 출력 PageNo 제한하기
	// = 1화면에 pageNo 3개씩 출력하기
	@RequestMapping(value = "/plist2")
	public ModelAndView plist2(ModelAndView mv, PageVO pvo) {
		// 1. currPage (요청받은 Page) 찾기
		// => 처음요청 : 1 page
		// => pageList 에서 요청이 들어온 경우 : pvo.getCurrPage()
		int currPage = 1;
		if (pvo.getCurrPage() > 1)
			 currPage = pvo.getCurrPage();
		else pvo.setCurrPage(currPage);
				
		// 2. DAO 처리 -> DB 관련 처리
		// -> totalRocordCount: totalPage 수
		// -> record를 출력할 만큼만 select
		pvo = service.pageList(pvo);
		// -> totalPage 수 계산
		int totalPage = pvo.getTotalCount() / pvo.getPerPage();
		if (pvo.getTotalCount() % pvo.getPerPage() != 0)
			totalPage++;

		// 3. 출력할 startPage, endPage 찾기
		// => perPageNo : 한 화면에 출력되는 PageNo 갯수
		int sPage = 1, ePage = 1;
		
		// 예를들어 currPage=3 이고 perPageNo 가 3 이면 1,2,3 page까지 출력 되어야 하므로
		// 아래 처럼 currPage-1 을 perPageNo 으로 나눈다.
		// currPage=11 -> 10,11,12, => (11-1)/3 * 3 +1 = 10 
		sPage = ((currPage - 1) / pvo.getPerPageNo()) * pvo.getPerPageNo() + 1;
		ePage = sPage + pvo.getPerPageNo() - 1;

		// 4. View 에서 필요한 자료만 addObject
		mv.addObject("Banana", pvo.getList());
		mv.addObject("totalPage", totalPage);
		mv.addObject("currPage", currPage);
		mv.addObject("perPageNo", pvo.getPerPageNo());
		mv.addObject("sPage", sPage);
		mv.addObject("ePage", ePage);
		mv.setViewName("board/pageList2");
		return mv;
	} // plist2

	@RequestMapping(value = "/plist")//http://localhost:9090/green/plist<까지 들어온것
	public ModelAndView plist(ModelAndView mv, PageVO pvo) {//currPage=2 ->pvo에들어온것, list에는 currpage가없음
		// 1. currPage (요청받은 Page) 찾기
		// -> currPage: 첫요청 : pvo에 없음,
		// pageNo click해서 요청하는경우 : pvo의 currPage에 set
		// -> currPage: start_Record ~ end_Record 계산
		int cpage = 1;
		if (pvo.getCurrPage() > 1)
			cpage = pvo.getCurrPage();
		else
			pvo.setCurrPage(cpage);

		// 2. DAO 처리 -> DB 관련 처리
		// -> totalRocordCount: totalPage 수
		// -> record를 출력할 만큼만 select
		pvo = service.pageList(pvo);
		// -> totalPage 수 계산
		int totalPage = pvo.getTotalCount() / pvo.getPerPage();
		if (pvo.getTotalCount() % pvo.getPerPage() != 0)
			totalPage++;

		// => 결과 출력
		mv.addObject("totalPage", totalPage);
		mv.addObject("currPage", pvo.getCurrPage());
		mv.addObject("Banana", pvo.getList());
		mv.setViewName("board/pageList");
		return mv;
	} // plist

	@RequestMapping(value = "/blist")
	public ModelAndView blist(ModelAndView mv) {
		ArrayList<BoardVO> blist = service.selectList();
		mv.addObject("Banana", blist);
		mv.setViewName("board/boardList");
		return mv;
	} // blist

	@RequestMapping(value = "/bdetail")
	public ModelAndView bdetail(HttpServletRequest request, ModelAndView mv, BoardVO vo) {
		// ** 조회수 증가 기능 추가
		// => 로그인 한 사람과 글쓴이가 동일인인지 판별
		// => 동일인이 아닌경우에만 -> board 수정:count=count+1
		String loId = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			loId = (String) session.getAttribute("loginID");
			// equals 비교시에 왼편이 not null 이어야 함
			if (vo.getId() != null && (!vo.getId().equals(loId))) {
				if (service.countUp(vo) > 0)
					System.out.println("** Controller bdetail => countUp 성공");
				else
					System.out.println("** Controller bdetail => countUp 실패");
			}
		} else
			System.out.println("** Controller bdetail => session is null");

		vo = service.selectOne(vo);
		if (vo == null) {
			System.out.println("** Controller bdetail => vo is null");
		} else {
			// ** 답글 처리를 위한 data보관
			// => session에 원글의 seq, root, step, indent 보관
			session.setAttribute("root", vo.getRoot());
			session.setAttribute("step", vo.getStep());
			session.setAttribute("indent", vo.getIndent());
			mv.addObject("Apple", vo);
		}
		mv.setViewName("board/boardDetail");
		return mv;
	} // bdetail

	@RequestMapping(value = "/binsertf")
	public ModelAndView binserf(ModelAndView mv) {
		mv.setViewName("board/binsertForm");
		return mv;
	}

	@RequestMapping(value = "/binsert")
	public ModelAndView binsert(ModelAndView mv, BoardVO vo) {
		int cnt = 0;
		cnt = service.insert(vo);
		if (cnt > 0) {
			mv.setViewName("redirect:blist");
		} else {
			mv.addObject("fCode", "I");
			mv.setViewName("board/boardFinish");
		}
		return mv;
	} // binsert

	@RequestMapping(value = "/bupdate")
	public ModelAndView bupdate(ModelAndView mv, BoardVO vo) {
		int cnt = 0;
		cnt = service.update(vo);
		if (cnt > 0) {
			mv.setViewName("redirect:blist");
		} else {
			mv.addObject("fCode", "U");
			mv.setViewName("board/boardFinish");
		}
		return mv;
	} // bupdate

	@RequestMapping(value = "/bdelete")
	public ModelAndView bdelete(ModelAndView mv, BoardVO vo) {
		// 답글 추가 이후
		// ** 원글인지 댓글인지 구별 가능해야 함 : root == seq 비교가 필요
		// => 원글의 삭제 시에는 모든 답글들 같이 삭제 : 모든 답글을 찾기위해서는 root 값 필요
		// => 답글의 삭제시에는 해당 답글만 삭제 : 해당 댓글의 seq 값 필요
		// ** 위의 필요값들은 이미 댓글 기능 구현을 위해서 session에 보관
		// -> 이를 get 해서 사용 또는 form 에서 전송받음
		int cnt = 0;
		cnt = service.delete(vo);
		if (cnt > 0) {
			mv.setViewName("redirect:blist");
		} else {
			mv.addObject("fCode", "D");
			mv.setViewName("board/boardFinish");
		}
		return mv;
	} // bdelete

	@RequestMapping(value = "/rinsertf")
	public ModelAndView rinserf(ModelAndView mv) {
		mv.setViewName("board/rinsertForm");
		return mv;
	}

	@RequestMapping(value = "/rinsert")
	public ModelAndView rinsert(HttpServletRequest request, ModelAndView mv, BoardVO vo) {
		// 원글의 seq, root, step, indent 가 필요
		// 1) => detail 에서 이 값들을 session 에 보관.
		// 2) => sesion에 보관해둔 부모글(원글)의 root, step, indent get하여
		// 입력하려는 답글의 root, step, indent을 계산
		// step , indent 는 1씩 증가 시켜주면 됨.
		int cnt = 0;
		int pstep = 0;
		int pindent = 0;
		HttpSession session = request.getSession(false);
		if (session != null) {
			pstep = (Integer) session.getAttribute("step");
			pindent = (Integer) session.getAttribute("indent");
		} else
			System.out.println("** Controller rinsert => session null ");

		// vo 에 set
		vo.setStep(++pstep);
		vo.setIndent(++pindent);
		cnt = service.rinsert(vo);
		if (cnt > 0)
			mv.setViewName("redirect:blist");
		else {
			mv.addObject("fCode", "RF");
			mv.setViewName("board/boardFinish");
		}
		return mv;
	} // rinsert
} // class
