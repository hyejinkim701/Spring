package vo;

import java.util.ArrayList;

public class PageVO {
	private ArrayList<BoardVO> list; // Page 에 출력할 Data 목록
	private int currPage ; // 출력할 PageNo
	private int perPage=5 ; // 1page 당 출력할 record 갯수
	private int totalCount ; //  total record 갯수
	private int perPageNo = 3; // 한 화면에 출력되는 PageNo 갯수
	
	public ArrayList<BoardVO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardVO> list) {
		this.list = list;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPerPageNo() {
		return perPageNo;
	}
	public void setPerPageNo(int perPageNo) {
		this.perPageNo = perPageNo;
	}
	@Override
	public String toString() {
		return "PageVO [list=" + list + ", currPage=" + currPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ ", perPageNo=" + perPageNo + "]";
	}
	
} // class
